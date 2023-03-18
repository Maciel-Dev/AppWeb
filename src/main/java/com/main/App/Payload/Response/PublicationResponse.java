package com.main.App.Payload.Response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PublicationResponse {
    private String theme;
    private int participants;

    public PublicationResponse(String theme, int participants){
        this.theme = theme;
        this.participants = participants;
    }
}
