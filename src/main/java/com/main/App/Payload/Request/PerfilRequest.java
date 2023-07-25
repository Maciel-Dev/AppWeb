package com.main.App.Payload.Request;

import com.main.App.Models.Topic;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PerfilRequest {
    @NotBlank
    private String biography;
//    private List<Long> topics;
    @NotBlank
    private String gender;
    @NotBlank
    private Long fkUser;

}
