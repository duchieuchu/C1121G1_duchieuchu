package com.example.book.controllers;

import com.example.book.models.ERole;
import com.example.book.models.Role;
import com.example.book.models.User;
import com.example.book.payload.request.LoginResquest;
import com.example.book.payload.request.SignUpRequest;
import com.example.book.payload.response.JwtResponse;
import com.example.book.payload.response.MessageResponse;
import com.example.book.repository.RoleRepository;
import com.example.book.repository.UserRepository;
import com.example.book.security.jwt.JwtUtils;
import com.example.book.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginResquest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();
        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case "mod":
                        Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);

                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    //http://localhost:8080/social/google
    @PostMapping("/google")
    public ResponseEntity<LoginResponse> loginWithGoogle(@RequestBody TokenDto tokenDto) throws Exception {
        System.out.println("pass " + password);
        NetHttpTransport transport = new NetHttpTransport();
        JacksonFactory factory = JacksonFactory.getDefaultInstance();
        GoogleIdTokenVerifier.Builder ver =
                new GoogleIdTokenVerifier.Builder(transport,factory)
                        .setAudience(Collections.singleton(idClient));
        GoogleIdToken googleIdToken = GoogleIdToken.parse(ver.getJsonFactory(),tokenDto.getToken());
        GoogleIdToken.Payload payload = googleIdToken.getPayload();
        email = payload.getEmail();
        User user = new User();
        if(userService.ifEmailExist(email)){
            user = userService.getUserByMail(email);
        } else {
            user = createUser(email);
        }
        ///////////////////////////
        JwtLogin jwtLogin = new JwtLogin();
        jwtLogin.setEmail(user.getEmail());
        jwtLogin.setPassword(password);
        ///////////////////////////

        return new ResponseEntity<LoginResponse>(tokenService.login(jwtLogin), HttpStatus.OK);
    }

    private User createUser(String email) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        List<Role> roles = roleService.getRoles();
        user.getRoles().add(roles.get(0));
        return userService.saveUser(user);
    }

    //http://localhost:8080/social/facebook
    @PostMapping("/facebook")
    public ResponseEntity<LoginResponse> loginWithFacebook(@RequestBody TokenDto tokenDto) throws Exception {
        Facebook facebook = new FacebookTemplate(tokenDto.getToken());
        String [] data = {"email"};
        org.springframework.social.facebook.api.User user = facebook.fetchObject("me", org.springframework.social.facebook.api.User.class,data);

        email = user.getEmail();
        User userFace = new User();
        if(userService.ifEmailExist(email)){
            userFace = userService.getUserByMail(email);
        } else {
            userFace = createUser(email);
        }
        ///////////////////////////
        JwtLogin jwtLogin = new JwtLogin();
        jwtLogin.setEmail(user.getEmail());
        jwtLogin.setPassword(password);
        ///////////////////////////

        return new ResponseEntity<LoginResponse>(tokenService.login(jwtLogin), HttpStatus.OK);
    }

}
