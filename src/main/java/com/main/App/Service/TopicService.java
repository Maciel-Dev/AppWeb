package com.main.App.Service;

import com.main.App.Models.Event;
import com.main.App.Models.Topic;
import com.main.App.Repositories.EventRepository;
import com.main.App.Repositories.TopicRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TopicService {
    @Autowired
    private TopicRepository tr;

    public Topic save(Topic topic){
        return tr.save(topic);
    }

    public List<Topic> findAll(){
        return tr.findAll();
    }

    public Topic findById(Long id){
        return tr.findById(id).orElseThrow(() -> new RuntimeException("Topic not found!"));
    }

    public void delete(Long id){
        tr.deleteById(id);
    }
}
