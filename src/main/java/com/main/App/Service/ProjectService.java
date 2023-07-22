package com.main.App.Service;

import com.main.App.Models.*;
import com.main.App.Payload.Request.ProjectRequest;
import com.main.App.Payload.Response.ProjectResponse;
import com.main.App.Repositories.PerfilRepository;
import com.main.App.Repositories.ProjectRepository;
import com.main.App.Repositories.TopicRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ProjectService {

    @Autowired
    private ProjectRepository pr;
    @Autowired
    private PerfilRepository pfr;
    @Autowired
    private TopicRepository tr;

    public ProjectResponse create(ProjectRequest req){

        var project = Project.builder()
                .title(req.getTitle())
                .type("PROJETO")
                .description(req.getDescription())
                .theme(req.getTheme())
                .participants(req.getParticipants())
                .build();

        pr.save(project);

        return ProjectResponse.builder().description(project.getDescription()).title(project.getTitle()).type("PROJETO").participants(project.getParticipants()).build();
    }


}
