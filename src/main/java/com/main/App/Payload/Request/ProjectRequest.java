package com.main.App.Payload.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProjectRequest {
    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @NotBlank
    private String theme;
    @NotBlank
    private int participants;
}
