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

    @PostMapping("/post")
    public ResponseEntity<EventResponse> add(@RequestBody EventRequest Event) throws NoSuchFieldException {
        return ResponseEntity.status(HttpStatus.CREATED).body(eventService.adicionarEvento(Event));
    }

    //TODO REFAZER UPDATE PASSANDO PARA O PADRÃO DE SERVIÇO E REPOSITÓRIO DO PROJETO

//    @PostMapping("/update/{id}")
//    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody EventRequest ev){
//        Event findEvent = eventService.findById(id);
//
//        if (findEvent != null){
//            findEvent.setTitle(ev.getTitle());
//            findEvent.setDescription(ev.getDescription());
//            findEvent.setDateTime(ev.getDateTime());
//            findEvent.setType(ev.getType());
//
//            Event updatedEvent = eventService.save(findEvent);
//
//            EventResponse response = new EventResponse(updatedEvent.getId(), updatedEvent.getTitle(),
//                    updatedEvent.getDescription(), updatedEvent.getDateTime(), updatedEvent.getType());
//
//            return ResponseEntity.status(HttpStatus.CREATED).body(response);
//        }else{
//            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
//        }
//    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        eventService.delete(id);
    }

}
