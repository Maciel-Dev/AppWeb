package com.main.App.Security.services;

import com.main.App.Models.ERole;
import com.main.App.Models.Role;
import com.main.App.Models.User;
import com.main.App.Payload.Request.AuthenticationRequest;
import com.main.App.Payload.Request.LoadRequest;
import com.main.App.Payload.Request.RegisterRequest;
import com.main.App.Payload.Response.AuthenticationResponse;
import com.main.App.Payload.Response.LogoutResponse;
import com.main.App.Payload.Response.RegisterResponse;
import com.main.App.Repositories.RoleRepository;
import com.main.App.Repositories.UserRepository;
import com.main.App.Security.jwt.JwtUtils;
import com.main.App.Service.UserAuthentication.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;
    @Autowired
    RoleRepository roleRepository;

    public RegisterResponse register(RegisterRequest request) {
        Set<String> strRoles = request.getRoles();
        Set<Role> roles = new HashSet<>();

        Role userRole = roleRepository.findByName(ERole.ROLE_USER).orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        ;

        roles.add((Role) userRole);

        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .username(request.getUsername())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .img_profile(request.getFile_image().getOriginalFilename())
                .roles(roles)
                .build();

        userRepository.save(user); // Salvando no Banco

        return RegisterResponse.builder()
                .Message("Usuário " + request.getEmail() + " cadastrado com Sucesso").build();
    }

    public AuthenticationResponse login(AuthenticationRequest authenticationRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        // Usuário do SPRING SECURITY
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> role = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toList();

        // Retorna usuário do Banco de Dados
        Optional<User> user = userRepository.findByUsername(authenticationRequest.getUsername());

        if (user.isPresent()) {
            return AuthenticationResponse.builder().
                    userDetails(userDetails)
                    .token(jwt)
                    .firstName(user.get().getFirstName())
                    .lastName(user.get().getLastName())
                    .id_user(user.get().getId().toString())
                    .build();
        } else {
            return AuthenticationResponse.builder().
                    userDetails(userDetails)
                    .token(jwt)
                    .build();
        }
    }

    public LogoutResponse loadUser(LoadRequest loadRequest) {
        boolean validToken = jwtUtils.validateJwtToken(loadRequest.getToken());
        if (validToken) {
            String user = jwtUtils.getUserNameFromJwtToken(loadRequest.getToken());
            Optional<User> userFind = userRepository.findByUsername(user);
            System.out.println(userFind);
            return LogoutResponse.builder().message("PASSEI").build();
        }
        return LogoutResponse.builder().message("NAO PASSEI").build();

    }
}
