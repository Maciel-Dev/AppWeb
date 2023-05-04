package com.main.App.Service;

import com.main.App.Models.Mentoring;
import com.main.App.Repositories.MentoringRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class MentoringService {
    @Autowired
    private MentoringRepository mr;

    public Mentoring save(Mentoring mentoring){
        return mr.save(mentoring);
    }

    public List<Mentoring> findAll(){
        return mr.findAll();
    }

    public Mentoring findById(Long id){
        return mr.findById(id).orElseThrow(() -> new RuntimeException("Mentoring not found!"));
    }

    public void delete(Long id){
        mr.deleteById(id);
    }
}
