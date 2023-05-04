package com.main.App.Payload.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TopicRequest {
    @NotBlank
    private String name;
}
