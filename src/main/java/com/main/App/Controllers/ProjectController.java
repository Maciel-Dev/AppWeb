package com.main.App.Controllers;

import com.main.App.Models.Project;
import com.main.App.Payload.Request.ProjectRequest;
import com.main.App.Payload.Response.ProjectResponse;
import com.main.App.Repositories.ProjectRepository;
import com.main.App.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth/projects")
@CrossOrigin
public class ProjectController {

    @Autowired
    ProjectService projectService;
    @Autowired
    ProjectRepository pr;

    @GetMapping("/get")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(projectService.findAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ProjectResponse> getProjectById(@PathVariable Long id){
        Project project = pr.findById(id).get();

        //contrução da resposta
        ProjectResponse response = ProjectResponse.builder()
                .id(project.getId())
                .title(project.getTitle())
                .description(project.getDescription())
                .perfilFK(project.getPerfil().getId())
                .theme(project.getTheme())
                .participants(project.getParticipants())
                .topics(project.getTopics())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/post")
    public ResponseEntity<ProjectResponse> create(@RequestBody ProjectRequest req){
        return ResponseEntity.status(HttpStatus.CREATED).body(projectService.create(req));
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ProjectRequest req){
        ProjectResponse response = projectService.update(id, req);

        if (response != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        pr.deleteById(id);
    }

}
