package com.main.App.Payload.Response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProjectResponse {
    private List<?> list;

    public ProjectResponse(List<?> list){
        this.list = list;
    }
}
