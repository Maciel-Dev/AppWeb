package com.main.App.Service;

import com.main.App.Models.Project;
import com.main.App.Payload.Response.ProjectResponse;
import com.main.App.Repositories.ProjectRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProjectService {

    @Autowired
    private ProjectRepository pr;

    public Project save(Project project){
        return pr.save(project);
    }

    public List<Project> findAll(){
        return pr.findAll();
    }

    public Project findById(Long id) {
        return pr.findById(id).orElseThrow(() -> new RuntimeException("Project not found!"));
    }

    public void delete(Long id){
        pr.deleteById(id);
    }
}
