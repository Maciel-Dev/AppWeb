package com.main.App.Service;

import com.main.App.Models.*;
import com.main.App.Payload.Request.CommentRequest;
import com.main.App.Payload.Request.EventRequest;
import com.main.App.Payload.Request.LikeRequest;
import com.main.App.Payload.Response.EventResponse;
import com.main.App.Payload.Response.LikeResponse;
import com.main.App.Repositories.CommentRepository;
import com.main.App.Repositories.EventRepository;
import com.main.App.Repositories.PerfilRepository;
import com.main.App.Repositories.PublicationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.*;

@Service
@Transactional
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PerfilRepository perfilRepository;
    @Autowired
    private PublicationRepository publicationRepository;

    public Comment save(CommentRequest comment) {

        Publication publication = publicationRepository.findPublicationByIdQuery(Long.parseLong(comment.getFk_pub()));

        publication.getComments().add(Comment.builder().message(comment.getDescription()).perfil(perfilRepository.findPerfilByIdQuery(Long.valueOf(comment.getFk_perfil()))).build());

        return Comment.builder().build();
    }

}
