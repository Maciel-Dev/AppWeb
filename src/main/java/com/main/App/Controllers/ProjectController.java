package com.main.App.Controllers;

import com.main.App.Models.Project;
import com.main.App.Payload.Request.ProjectRequest;
import com.main.App.Payload.Response.ProjectResponse;
import com.main.App.Payload.Response.UserInfoResponse;
import com.main.App.Repositories.ProjectRepository;
import com.main.App.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.expression.ExpressionException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @GetMapping("/get")
    public ResponseEntity<?> getAll(){

        return ResponseEntity.ok()
                .body(projectService.listAll());
    }

    @PostMapping("/post")
    public ResponseEntity<?> add(@RequestBody ProjectRequest project){
        try {
            Project newProject = new Project(
                    project.getTitle(),
                    project.getDescription(),
                    project.getTheme(),
                    project.getParticipants()
            );
            projectService.save(newProject);
            return ResponseEntity.ok().body(newProject);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Cannot create post");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            projectService.delete(id);
            return ResponseEntity.ok().body("Project deleted");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Cannot delete project");
        }
    }
}
