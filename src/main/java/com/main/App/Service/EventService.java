package com.main.App.Service;

import com.main.App.Models.Event;
import com.main.App.Models.Publication;
import com.main.App.Models.TypePublication;
import com.main.App.Payload.Request.EventRequest;
import com.main.App.Payload.Request.LikeRequest;
import com.main.App.Payload.Response.EventResponse;
import com.main.App.Payload.Response.LikeResponse;
import com.main.App.Repositories.EventRepository;
import com.main.App.Repositories.PublicationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class EventService {
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private PublicationRepository publicationRepository;

    public Event save(Event event) {
        return eventRepository.save(event);
    }

    public LikeResponse like (LikeRequest likeRequest){
        publicationRepository.increaseLikesPublication(Long.parseLong(likeRequest.getId()));

        return LikeResponse.builder().message("OK").build();
    }

    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    public Event findById(Long id) {
        return eventRepository.findById(id).orElseThrow(() -> new RuntimeException("Event not found!"));
    }

    public void delete(Long id) {
        eventRepository.deleteById(id);
    }

    public EventResponse adicionarEvento(EventRequest eventRequest) throws NoSuchFieldException {
        var event = Event.builder()
                .likes(0L)
                .data(new Date())
                .title(eventRequest.getTitle())
                .description(eventRequest.getDescription())
                .type(String.valueOf(TypePublication.EVENTO))
                .dateTime(LocalDateTime.now())
                .build();

        eventRepository.save(event);

        return EventResponse.builder()
                .type(String.valueOf(TypePublication.EVENTO))
                .title(eventRequest.getTitle())
                .description(eventRequest.getDescription())
                .dateTime(eventRequest.getDateTime())
                .build();
    }
}
