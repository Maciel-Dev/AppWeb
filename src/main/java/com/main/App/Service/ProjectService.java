package com.main.App.Service;

import com.main.App.Models.Project;
import com.main.App.Repositories.ProjectRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProjectService {

    @Autowired
    private ProjectRepository pr;

    public List<Project> listAll(){
        return pr.findAll();
    }

    public void save(Project project){
        pr.save(project);
    }

    public void delete(Long id){
        pr.deleteById(id);
    }
}
