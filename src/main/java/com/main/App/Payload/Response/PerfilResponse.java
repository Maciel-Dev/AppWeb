package com.main.App.Payload.Response;

import lombok.*;

import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PerfilResponse {
    private Long id;
    private String biography;
    private Date creationDate;
    private Long fkUser;
}
