package com.main.App.Controllers;

import com.main.App.Models.ERole;
import com.main.App.Models.Role;
import com.main.App.Models.User;
import com.main.App.Payload.Request.AuthenticationRequest;
import com.main.App.Payload.Request.LoginRequest;
import com.main.App.Payload.Request.RegisterRequest;
import com.main.App.Payload.Request.SignupRequest;
import com.main.App.Payload.Response.AuthenticationResponse;
import com.main.App.Payload.Response.MessageResponse;
import com.main.App.Payload.Response.UserInfoResponse;
import com.main.App.Repositories.RoleRepository;
import com.main.App.Repositories.UserRepository;
import com.main.App.Security.jwt.JwtUtils;
import com.main.App.Security.services.AuthenticationService;
import com.main.App.Security.services.UserDetailsImpl;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(authenticationService.authenticated(request));
    }

}
