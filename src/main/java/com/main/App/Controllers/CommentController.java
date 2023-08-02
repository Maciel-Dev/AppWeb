package com.main.App.Controllers;

import com.main.App.Models.Publication;
import com.main.App.Payload.Request.CommentRequest;
import com.main.App.Repositories.PublicationRepository;
import com.main.App.Service.CommentService;
import com.main.App.Service.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

@RestController
@RequestMapping("/comment")
@CrossOrigin
public class CommentController {

    @Autowired
    CommentService commentService;
    @PostMapping("/add")
    public ResponseEntity<?> post(@RequestBody CommentRequest commentRequest) {
        return ResponseEntity.ok().body(commentService.save(commentRequest));
    }

}
