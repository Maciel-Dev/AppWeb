package com.main.App.Repositories;

import com.main.App.Models.SocialNetwork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SocialNetworkRepository extends JpaRepository<SocialNetwork, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM webapp.social_networks WHERE fk_perfil = :fk")
    SocialNetwork findSocialNetworkByPerfil(Long fk);

}
