package com.main.App.Payload.Response;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TopicResponse {
    private Long id;
    private String name;
}
