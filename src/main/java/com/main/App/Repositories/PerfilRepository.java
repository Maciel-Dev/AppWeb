package com.main.App.Repositories;

import com.main.App.Models.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM webapp.perfils WHERE fk_user = :fk")
    Perfil findPerfilByUser(Long fk);
}
