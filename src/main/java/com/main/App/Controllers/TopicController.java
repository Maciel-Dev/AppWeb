package com.main.App.Controllers;

import com.main.App.Models.Topic;
import com.main.App.Payload.Request.TopicRequest;
import com.main.App.Payload.Response.TopicResponse;
import com.main.App.Service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth/topic")
@CrossOrigin
public class TopicController {

    @Autowired
    TopicService topicService;

    @GetMapping("/get")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok().body(topicService.findAll());
    }

    @GetMapping("/{id}")
    public Topic getTopicById(@PathVariable Long id){
        return topicService.findById(id);
    }

    @PostMapping("/post")
    public ResponseEntity<TopicResponse> add(@RequestBody TopicRequest tr){
        Topic mentoring = new Topic(tr.getName());

        Topic newTopic = topicService.save(mentoring);

        TopicResponse response = new TopicResponse(newTopic.getId(), newTopic.getName());

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody TopicRequest tr){
        Topic findTopic = topicService.findById(id);

        if (findTopic != null){
            findTopic.setName(tr.getName());

            Topic updatedTopic = topicService.save(findTopic);

            TopicResponse response = new TopicResponse(updatedTopic.getId(), updatedTopic.getName());

            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        topicService.delete(id);
    }
}
