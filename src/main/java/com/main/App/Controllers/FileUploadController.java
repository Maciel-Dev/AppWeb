package com.main.App.Controllers;

import lombok.RequiredArgsConstructor;
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

@RestController
@RequestMapping("/api/auth/fileUpload")
@RequiredArgsConstructor
@CrossOrigin
public class FileUploadController {

    private final Path root = Paths.get("public/uploads");

    @PostMapping("/sendImageProfile")
    public ResponseEntity<MultipartFile> sendFile(@RequestParam MultipartFile multipartFile) throws IOException {
        Files.createDirectories(root);
        Files.copy(multipartFile.getInputStream(), this.root.resolve(Objects.requireNonNull(multipartFile.getOriginalFilename())));
//        multipartFile.transferTo(new File("../resources/public/" + multipartFile.getOriginalFilename()));
        return ResponseEntity.ok().build();
    }

}
