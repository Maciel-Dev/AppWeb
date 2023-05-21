package com.main.App.Payload.Response;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TelephoneResponse {
    @NotBlank
    private Long id;
    @NotBlank
    private Short ddd;
    @NotBlank
    private Integer number;
}
