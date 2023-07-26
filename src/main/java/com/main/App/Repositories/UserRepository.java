package com.main.App.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.main.App.Models.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Boolean existsByEmail(String email);
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);

    @Modifying
    @Query(nativeQuery = true, value = "UPDATE users SET first_login = 0 WHERE id = :fk")
    void setFirstLogin(Long fk);

    @Query(nativeQuery = true, value = "SELECT id FROM perfils WHERE fk_user = :fk")
    String findIdPerfilByUser(Long fk);

}
