package com.main.App.Payload.Request;

import com.main.App.Models.TypePublication;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EventRequest {
    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @NotBlank
    private LocalDateTime dateTime;
    @NotBlank
    private TypePublication type;
}
