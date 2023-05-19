package com.main.App.Payload.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SocialNetworkRequest {
    private Long id;
    private String linkedin;
    private String instagram;
    private String telegram;
    @NotBlank
    private Long perfilID;
}
