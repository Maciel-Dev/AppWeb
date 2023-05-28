package com.main.App.Service;

import com.main.App.Models.Perfil;
import com.main.App.Models.Project;
import com.main.App.Payload.Request.ProjectRequest;
import com.main.App.Payload.Response.ProjectResponse;
import com.main.App.Repositories.PerfilRepository;
import com.main.App.Repositories.ProjectRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProjectService {

    @Autowired
    private ProjectRepository pr;
    @Autowired
    private PerfilRepository pfr;

    public ProjectResponse create(ProjectRequest req){
        //busca perfil no banco de dados
        Perfil perfil = pfr.findById(req.getPerfilFk()).get();
        //cria um projeto
        Project project = Project.builder()
                .title(req.getTitle())
                .description(req.getDescription())
                .perfil(perfil)
                .theme(req.getTheme())
                .participants(req.getParticipants())
                .build();
        //salva o projeto no banco de dados
        project = pr.save(project);

        //contrução da resposta
        ProjectResponse response = ProjectResponse.builder()
                .id(project.getId())
                .title(project.getTitle())
                .description(project.getDescription())
                .perfilFK(perfil.getId())
                .theme(project.getTheme())
                .participants(project.getParticipants())
                .build();
        return response;
    }

    public ProjectResponse update(Long id, ProjectRequest req){
        Project project = pr.findById(id).get();

        if(project != null){
            project.setTitle(req.getTitle());
            project.setDescription(req.getDescription());
            project.setTheme(req.getTheme());
            project.setParticipants(req.getParticipants());

            project = pr.save(project);
        }

        //contrução da resposta
        ProjectResponse response = ProjectResponse.builder()
                .id(project.getId())
                .title(project.getTitle())
                .description(project.getDescription())
                .perfilFK(project.getPerfil().getId())
                .theme(project.getTheme())
                .participants(project.getParticipants())
                .build();
        return response;
    }

    public List<ProjectResponse> findAll(){
        List<Project> projects = pr.findAll();
        List<ProjectResponse> projectListResponse = new ArrayList<>();

        for (Project project : projects){
            //contrução da resposta
            ProjectResponse response = ProjectResponse.builder()
                    .id(project.getId())
                    .title(project.getTitle())
                    .description(project.getDescription())
                    .perfilFK(project.getPerfil().getId())
                    .theme(project.getTheme())
                    .participants(project.getParticipants())
                    .build();
            //adição da resposta na lista
            projectListResponse.add(response);
        }
        return projectListResponse;
    }

}
