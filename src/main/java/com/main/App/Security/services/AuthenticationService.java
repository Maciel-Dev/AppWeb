package com.main.App.Security.services;

import com.main.App.Models.Role;
import com.main.App.Models.User;
import com.main.App.Payload.Request.AuthenticationRequest;
import com.main.App.Payload.Request.RegisterRequest;
import com.main.App.Payload.Response.AuthenticationResponse;
import com.main.App.Repositories.UserRepository;
import com.main.App.Security.jwt.JwtService;
import io.micrometer.core.instrument.util.IOUtils;
import io.micrometer.core.ipc.http.HttpSender;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.tools.FileObject;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.PasswordAuthentication;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .img_profile(request.getFile_image().getOriginalFilename()) // Salva o nome da Imagem no Banco de Dados
                .role(Role.USER)
                .build();

        repository.save(user);

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .userDetails(user)
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticated(AuthenticationRequest request) throws IOException {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = repository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);


        return AuthenticationResponse.builder()
                .userDetails(user)
                .token(jwtToken)
                .multipartFile(user.getImg_profile())
                .build();
    }
}
