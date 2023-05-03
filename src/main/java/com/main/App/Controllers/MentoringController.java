package com.main.App.Controllers;

import com.main.App.Models.Mentoring;
import com.main.App.Models.Project;
import com.main.App.Payload.Request.MentoringRequest;
import com.main.App.Payload.Request.ProjectRequest;
import com.main.App.Payload.Response.MentoringResponse;
import com.main.App.Payload.Response.ProjectResponse;
import com.main.App.Service.MentoringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth/mentoring")
@CrossOrigin
public class MentoringController {

    @Autowired
    MentoringService mentoringService;

    @GetMapping("/get")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok().body(mentoringService.findAll());
    }

    @GetMapping("/{id}")
    public Mentoring getMentoringById(@PathVariable Long id){
        return mentoringService.findById(id);
    }

    @PostMapping("/post")
    public ResponseEntity<MentoringResponse> add(@RequestBody MentoringRequest mt){
        Mentoring mentoring = new Mentoring(mt.getTitle(), mt.getDescription(), mt.getDiscipline(), mt.getDuration());

        Mentoring newMentoring = mentoringService.save(mentoring);

        MentoringResponse response = new MentoringResponse(newMentoring.getId(), newMentoring.getTitle(),
                newMentoring.getDescription(), newMentoring.getDiscipline(), newMentoring.getDuration());

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody MentoringRequest mt){
        Mentoring findMentoring = mentoringService.findById(id);

        if (findMentoring != null){
            findMentoring.setTitle(mt.getTitle());
            findMentoring.setDescription(mt.getDescription());
            findMentoring.setDiscipline(mt.getDiscipline());
            findMentoring.setDuration(mt.getDuration());

            Mentoring updatedMentoring = mentoringService.save(findMentoring);

            MentoringResponse response = new MentoringResponse(updatedMentoring.getId(), updatedMentoring.getTitle(),
                    updatedMentoring.getDescription(), updatedMentoring.getDiscipline(), updatedMentoring.getDuration());

            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        mentoringService.delete(id);
    }
}
