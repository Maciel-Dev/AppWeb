package com.main.App.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class Publication {
    private String title;
    private String description;

    public Publication(String title, String description){
        this.title = title;
        this.description = description;
    }
}
