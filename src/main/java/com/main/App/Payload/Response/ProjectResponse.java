package com.main.App.Payload.Response;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProjectResponse {
    private Long id;
    private String title;

    private String description;

    private Long perfilFK;

    private String theme;

    private int participants;
}
