package com.main.App.Payload.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TelephoneRequest {
    @NotBlank
    private Short ddd;
    @NotBlank
    private Integer number;
    @NotBlank
    private Long idUser;
}
