package com.main.App.Controllers;

import com.main.App.Models.Mentoring;
import com.main.App.Repositories.MentoringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/auth/mentoring")
@CrossOrigin
public class MentoringController {

    @Autowired
    private MentoringRepository mr;

    public List<Mentoring> listAll(){
        return mr.findAll();
    }

    public void save(Mentoring mentoring){
        mr.save(mentoring);
    }

    public void delete(Long id){
        mr.deleteById(id);
    }
}
