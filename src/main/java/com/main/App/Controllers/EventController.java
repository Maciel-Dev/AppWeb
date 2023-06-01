package com.main.App.Controllers;

import com.main.App.Models.Event;
import com.main.App.Models.Mentoring;
import com.main.App.Payload.Request.EventRequest;
import com.main.App.Payload.Request.MentoringRequest;
import com.main.App.Payload.Response.EventResponse;
import com.main.App.Payload.Response.MentoringResponse;
import com.main.App.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth/evento")
@CrossOrigin
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/get")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok().body(eventService.findAll());
    }

    @GetMapping("/{id}")
    public Event getEventById(@PathVariable Long id){
        return eventService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        eventService.delete(id);
    }

}
