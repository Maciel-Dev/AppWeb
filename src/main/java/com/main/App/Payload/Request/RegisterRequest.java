package com.main.App.Payload.Request;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@MultipartConfig
@Getter
@Setter
public class RegisterRequest {

    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private MultipartFile file_image;

}
