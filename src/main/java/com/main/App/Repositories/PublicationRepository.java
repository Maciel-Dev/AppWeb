package com.main.App.Repositories;

import com.main.App.Models.Perfil;
import com.main.App.Models.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Long> {
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE publication SET likes = likes + 1 WHERE id = ?1")
    void increaseLikesPublication(Long id);
}