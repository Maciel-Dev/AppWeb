package com.main.App.Controllers;

import com.main.App.Models.Project;
import com.main.App.Service.ProjectService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjectController {

    private ProjectService service;

    @GetMapping("/project")
    public List<Project> getAll(){
        return service.listAll();
    }

    @PostMapping("/project")
    public void add(@RequestBody Project project){
        service.save(project);
    }
}
