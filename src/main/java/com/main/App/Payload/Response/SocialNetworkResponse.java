package com.main.App.Payload.Response;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SocialNetworkResponse {
    private Long id;
    private String linkedin;
    private String instagram;
    private String telegram;
}
