package com.main.App.Controllers;

import com.main.App.Models.Project;
import com.main.App.Payload.Response.UserInfoResponse;
import com.main.App.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService service;

    @GetMapping("/get")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok()
                .body("OK");
    }

    @PostMapping("/project")
    public void add(@RequestBody Project project){
        service.save(project);
    }
}
