package com.main.App.Payload.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MentoringRequest {
    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @NotBlank
    private String discipline;
    @NotBlank
    private LocalDateTime duration;
}
