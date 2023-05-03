package com.main.App.Payload.Request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MentoringRequest {

    @NotEmpty(message = "Title may not be empty")
    private String title;
    private String description;
    private String grade;
    private Integer duration;



}
