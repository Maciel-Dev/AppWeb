package com.main.App.Controllers;

import com.main.App.Models.Project;
import com.main.App.Payload.Request.ProjectRequest;
import com.main.App.Payload.Response.ProjectResponse;
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

    @GetMapping("/get")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok().body(projectService.findAll());
    }

    @GetMapping("/{id}")
        public Project getProjectById(@PathVariable Long id){
        return projectService.findById(id);
    }

    @PostMapping("/post")
    public ResponseEntity<ProjectResponse> add(@RequestBody ProjectRequest pr){
        Project project = new Project(pr.getTitle(), pr.getDescription(), pr.getTheme(), pr.getParticipants());

        Project newProject = projectService.save(project);

        ProjectResponse response = new ProjectResponse(newProject.getId(), newProject.getTitle(),
                newProject.getDescription(), newProject.getTheme(), newProject.getParticipants());

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ProjectRequest pr){
        Project findProject = projectService.findById(id);

        if (findProject != null){
            findProject.setTitle(pr.getTitle());
            findProject.setDescription(pr.getDescription());
            findProject.setTheme(pr.getTheme());
            findProject.setParticipants(pr.getParticipants());

            Project updatedProject = projectService.save(findProject);

            ProjectResponse response = new ProjectResponse(updatedProject.getId(), updatedProject.getTitle(),
                    updatedProject.getDescription(), updatedProject.getTheme(), updatedProject.getParticipants());

            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        projectService.delete(id);
    }

}
