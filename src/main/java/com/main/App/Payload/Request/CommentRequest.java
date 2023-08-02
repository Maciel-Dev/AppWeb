package com.main.App.Payload.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequest {
    @NotBlank
    private String Description;
    @NotBlank
    private String fk_perfil;
    @NotBlank
    private String fk_pub;

}
