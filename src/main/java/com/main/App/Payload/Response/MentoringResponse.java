package com.main.App.Payload.Response;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MentoringResponse {
    private String title;
    private String description;
    private String discipline;
    private LocalDateTime duration;
}
