package com.main.App.Controllers;

import com.main.App.Models.Event;
import com.main.App.Payload.Request.EventRequest;
import com.main.App.Payload.Request.LikeRequest;
import com.main.App.Payload.Response.EventResponse;
import com.main.App.Payload.Response.LikeResponse;
import com.main.App.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@RestController
@RequestMapping("/api/auth/evento")
@CrossOrigin
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/get")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok().body(eventService.findAll());
    }

    @GetMapping("/{id}")
    public Event getEventById(@PathVariable Long id) {
        return eventService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        eventService.delete(id);
    }

    @PostMapping("/post")
    public ResponseEntity<EventResponse> add(@ModelAttribute EventRequest request) throws NoSuchFieldException, IOException {
        return ResponseEntity.ok(eventService.adicionarEvento(request));
    }

    @PostMapping("/like")
    public ResponseEntity<LikeResponse> like(@RequestBody LikeRequest lk){
        return ResponseEntity.ok(eventService.like(lk));
    }
}
