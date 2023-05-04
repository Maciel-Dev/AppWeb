package com.main.App.Payload.Response;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.time.LocalTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MentoringResponse {
    private Long id;
    private String title;
    private String description;
    private String discipline;
    private LocalTime duration;
}
