package com.main.App.Payload.Response;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProjectResponse {
    private Long id;
    private String title;

    private String description;

    private String theme;

    private int participants;
}
