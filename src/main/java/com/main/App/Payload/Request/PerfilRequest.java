package com.main.App.Payload.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PerfilRequest {
    @NotBlank
    private String biography;
    @NotBlank
    private Long fkUser;

}
