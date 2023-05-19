package com.main.App.Payload.Response;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ContactResponse {
    private Long id;
    private String linkedin;
    private String instagram;
    private String telegram;
    private Long userId;
    private Long telephoneId;
}
