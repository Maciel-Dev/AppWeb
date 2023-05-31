package com.main.App.Payload.Response;

import com.main.App.Models.Topic;
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

    private Long perfilFK;

    private String theme;

    private int participants;

    private List<Topic> topics;
}
