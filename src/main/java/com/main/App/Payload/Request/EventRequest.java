package com.main.App.Payload.Request;

import com.main.App.Models.TypePublication;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EventRequest {
    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @NotBlank
    private LocalDateTime dateTime;
    @NotBlank
    private String type;
    @NotBlank
    private String author;
    @NotBlank
    private String id_perfil;
    @NotBlank
    private MultipartFile file_image;
}
