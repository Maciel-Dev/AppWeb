package com.main.App.Payload.Request;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@MultipartConfig
@Getter
@Setter
public class RegisterRequest {

    private Set<String> roles;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private MultipartFile file_image;

}
