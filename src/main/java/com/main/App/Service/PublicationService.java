package com.main.App.Service;

import com.main.App.Models.Event;
import com.main.App.Models.Publication;
import com.main.App.Models.TypePublication;
import com.main.App.Payload.Request.EventRequest;
import com.main.App.Payload.Request.LikeRequest;
import com.main.App.Payload.Response.EventResponse;
import com.main.App.Payload.Response.LikeResponse;
import com.main.App.Payload.Response.PublicationResponse;
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
public class PublicationService {
    @Autowired
    PublicationRepository publicationRepository;

    public PublicationResponse getAll(){
        return PublicationResponse.builder().publication(publicationRepository.findAll()).build();
    }

}
