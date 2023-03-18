package com.main.App.Controllers;

import com.main.App.Models.Project;
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
    public void add(@RequestBody Project project){
        projectService.save(project);
    }
}
