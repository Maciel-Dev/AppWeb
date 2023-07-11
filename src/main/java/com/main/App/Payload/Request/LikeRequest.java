package com.main.App.Payload.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LikeRequest {

    @NotBlank
    private String id;

}
