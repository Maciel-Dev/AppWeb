package com.main.App.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
@Getter
@Setter
public class Publication {
    private String title;
    private String description;
    public Publication(String title, String description) {
        this.title = title;
        this.description = description;
    }
    public Publication() {
    }
}
