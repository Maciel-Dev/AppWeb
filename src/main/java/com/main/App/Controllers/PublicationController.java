package com.main.App.Controllers;

import com.main.App.Models.Event;
import com.main.App.Models.Publication;
import com.main.App.Models.User;
import com.main.App.Payload.Request.EventRequest;
import com.main.App.Payload.Request.LikeRequest;
import com.main.App.Payload.Response.EventResponse;
import com.main.App.Payload.Response.LikeResponse;
import com.main.App.Repositories.PublicationRepository;
import com.main.App.Service.EventService;
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
@RequestMapping("/api/auth/publication")
@CrossOrigin
public class PublicationController {

    @Autowired
    private PublicationService publicationService;

    @Autowired
    private PublicationRepository publicationRepository;

    @GetMapping("/get")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok().body(publicationService.getAll());
    }

    @GetMapping("/image/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable("id") String id) throws IOException {
        Optional<Publication> publication = publicationRepository.findById(Long.parseLong(id));
        File imageFile = new File("public/uploads/imgs_files/" + publication.get().getImage_file());
        byte[] imageBytes = Files.readAllBytes(imageFile.toPath());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);

        return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
    }

}
