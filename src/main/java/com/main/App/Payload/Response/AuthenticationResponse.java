package com.main.App.Payload.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    private UserDetails userDetails;
    private String token;
    private String firstName;
    private String lastName;
    private String id_user;
    private String id_perfil;
    private boolean c_perfil;
    private boolean first_login;

}
