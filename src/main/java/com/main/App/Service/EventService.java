package com.main.App.Service;

import com.main.App.Models.Event;
import com.main.App.Repositories.EventRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class EventService {
    @Autowired
    private EventRepository er;

    public Event save(Event event){
        return er.save(event);
    }

    public List<Event> findAll(){
        return er.findAll();
    }

    public Event findById(Long id){
        return er.findById(id).orElseThrow(() -> new RuntimeException("Event not found!"));
    }

    public void delete(Long id){
        er.deleteById(id);
    }
}
