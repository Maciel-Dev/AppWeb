package com.main.App.Repositories;

import com.main.App.Models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    @Query(nativeQuery = true, value = "select pb.id, pb.data, pb.title, pb.description, pr.theme, pr.participants, pb.fk_perfil from webapp.projects pr\n" +
            "cross join webapp.publication pb\n" +
            "where pb.fk_perfil = :perfilFk")
    List<Project> getProjectByPerfil(Long perfilFk);
}
