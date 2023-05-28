package com.main.App.Controllers;

import com.main.App.Models.Topic;
import com.main.App.Payload.Request.TopicRequest;
import com.main.App.Payload.Response.TopicResponse;
import com.main.App.Repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth/topic")
@CrossOrigin
public class TopicController {
    @Autowired
    TopicRepository tr;

    @GetMapping("/get")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(tr.findAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<TopicResponse> getTopicById(@PathVariable Long id){
        Topic topic = tr.findById(id).get();

        if(topic != null){
            TopicResponse response = TopicResponse.builder()
                    .id(topic.getId())
                    .name(topic.getName())
                    .build();

            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping("/post")
    public ResponseEntity<TopicResponse> add(@RequestBody TopicRequest req){
        Topic mentoring = new Topic(req.getName());

        Topic newTopic = tr.save(mentoring);

        TopicResponse response = new TopicResponse(newTopic.getId(), newTopic.getName());

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<TopicResponse> update(@PathVariable Long id, @RequestBody TopicRequest req){
        Topic findTopic = tr.findById(id).get();

        if (findTopic != null){
            findTopic.setName(req.getName());

            Topic updatedTopic = tr.save(findTopic);

            TopicResponse response = new TopicResponse(updatedTopic.getId(), updatedTopic.getName());

            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        tr.deleteById(id);
    }
}
