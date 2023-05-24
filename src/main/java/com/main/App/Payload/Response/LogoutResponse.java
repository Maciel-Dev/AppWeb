package com.main.App.Payload.Response;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LogoutResponse {
    private String message;
}
