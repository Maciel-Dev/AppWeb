package com.main.App.Controllers;

import com.main.App.Models.User;
import com.main.App.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth/fileUpload")
@RequiredArgsConstructor
@CrossOrigin
public class FileUploadController {

    @Autowired
    UserRepository userRepository;
    private final Path root = Paths.get("public/uploads");

    @PostMapping("/sendImageProfile")
    public ResponseEntity<MultipartFile> sendFile(@RequestParam MultipartFile multipartFile) throws IOException {
        Files.createDirectories(root);
        Files.copy(multipartFile.getInputStream(), this.root.resolve(Objects.requireNonNull(multipartFile.getOriginalFilename())));
//        multipartFile.transferTo(new File("../resources/public/" + multipartFile.getOriginalFilename()));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/image/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable("id") String id) throws IOException{
        Optional<User> user = userRepository.findById(Long.parseLong(id));

        File imageFile = new File("public/uploads/" + user.get().getImg_profile());

        byte[] imageBytes = Files.readAllBytes(imageFile.toPath());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);

        return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
    }


}
