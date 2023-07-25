package com.main.App.Payload.Response;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EventResponse {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime dateTime;
    private String type;
    private Long like;
    private String author;
    private byte[] img_file;
}
