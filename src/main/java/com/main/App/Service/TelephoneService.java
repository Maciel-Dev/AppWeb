package com.main.App.Service;

import com.main.App.Models.Project;
import com.main.App.Models.Telephone;
import com.main.App.Repositories.TelephoneRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TelephoneService {
    @Autowired
    private TelephoneRepository tp;

    public Telephone save(Telephone telephone){
        return tp.save(telephone);
    }

    public List<Telephone> findAll(){
        return tp.findAll();
    }

    public Telephone findById(Long id) {
        return tp.findById(id).orElseThrow(() -> new RuntimeException("Telephone not found!"));
    }

    public void delete(Long id){
        tp.deleteById(id);
    }
}
