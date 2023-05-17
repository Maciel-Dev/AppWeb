package com.main.App.Controllers;

import com.main.App.Payload.Request.AuthenticationRequest;
import com.main.App.Payload.Request.RegisterRequest;
import com.main.App.Payload.Response.AuthenticationResponse;
import com.main.App.Security.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin
public class AuthController {

    private final Path root = Paths.get("public/uploads");
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@ModelAttribute RegisterRequest request) throws IllegalStateException, IOException {
        Files.createDirectories(root);
        Files.copy(request.getFile_image().getInputStream(), this.root.resolve(Objects.requireNonNull(request.getFile_image().getOriginalFilename())), StandardCopyOption.REPLACE_EXISTING);
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) throws IOException {
        // Lógica para ler a imagem do local adequado


        AuthenticationResponse auth = authenticationService.authenticated(request);

        if (auth != null) {
            return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + auth.getMultipartFile()).body(authenticationService.authenticated(request));
        }
        return (ResponseEntity<AuthenticationResponse>) ResponseEntity.status(403);
    }

//    @PostMapping("/logout")
//    public ResponseEntity<AuthenticationResponse> logout(){
//
//    }



    // TODO Criar função para fazer verificação do Token informado

}
