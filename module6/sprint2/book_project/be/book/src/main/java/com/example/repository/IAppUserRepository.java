package com.example.repository;

import com.example.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IAppUserRepository extends JpaRepository<AppUser, Integer> {

    @Query(value = "select * from app_user a where a.user_name = :name", nativeQuery = true)
    AppUser findAppUserByName(@Param("name") String name);

    @Query(value = "SELECT `user_name` from app_user where `name` = ?1", nativeQuery = true)
    String existsByUserName(String username);

    @Modifying
    @Query(value = "update app_user set password =?1 where `name` = ?2", nativeQuery = true)
    void saveNewPassword(String password, String name);
}
