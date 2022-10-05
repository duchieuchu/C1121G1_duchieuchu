package com.example.service.impl;

import com.example.model.AppUser;
import com.example.model.UserRole;
import com.example.repository.IAppUserRepository;
import com.example.repository.IUserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JwtUserDetailService implements UserDetailsService {

    @Autowired
    private IAppUserRepository iAppUserRepository;
    @Autowired
    private IUserRoleRepository iUserRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = iAppUserRepository.findAppUserByName(username);

        if (appUser == null) {
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }

        List<UserRole> userRoles = iUserRoleRepository.findAllByAppUser(appUser);

        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();

        if (userRoles != null) {
            for (UserRole item: userRoles) {
                GrantedAuthority authority = new SimpleGrantedAuthority(item.getAppRole().getName());
                grantedAuthorityList.add(authority);
            }
        }
        return new User(appUser.getUserName(), appUser.getPassword(), grantedAuthorityList);
    }
}
