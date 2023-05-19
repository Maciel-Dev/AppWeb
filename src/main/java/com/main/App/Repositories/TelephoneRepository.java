package com.main.App.Repositories;

import com.main.App.Models.Telephone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TelephoneRepository extends JpaRepository<Telephone, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM webapp.phones WHERE fk_perfil = :fk")
    List<Telephone> findPhonesByPerfil(Long fk);
}
