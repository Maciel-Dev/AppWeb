package com.main.App.Security.services;

import com.main.App.Payload.Request.AuthenticationRequest;
import com.main.App.Payload.Request.RegisterRequest;
import com.main.App.Payload.Response.AuthenticationResponse;
import com.main.App.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()

                .build();

        return null;
    }

    public AuthenticationResponse authenticated(AuthenticationRequest request) {
        return null;
    }
}
