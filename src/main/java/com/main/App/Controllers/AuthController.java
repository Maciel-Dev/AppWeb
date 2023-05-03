package com.main.App.Controllers;

import com.main.App.Payload.Request.AuthenticationRequest;
import com.main.App.Payload.Request.RegisterRequest;
import com.main.App.Payload.Response.AuthenticationResponse;
import com.main.App.Security.services.AuthenticationService;
import jdk.jfr.ContentType;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin
public class AuthController {

    private final Path root = Paths.get("public/uploads");
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@ModelAttribute RegisterRequest request) throws IOException {
//        Files.createDirectories(root);
//        Files.copy(multipartFile.getInputStream(), this.root.resolve(Objects.requireNonNull(multipartFile.getOriginalFilename())));
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(authenticationService.authenticated(request));
    }

//    @PostMapping("/logout")
//    public ResponseEntity<AuthenticationResponse> logout(){
//
//    }



    // TODO Criar função para fazer verificação do Token informado

}
