package com.main.App.Payload.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@MultipartConfig
public class RegisterRequest {

    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private MultipartFile file;

}
