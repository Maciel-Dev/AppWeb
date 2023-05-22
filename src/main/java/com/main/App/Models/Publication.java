package com.main.App.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public class Publication {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    private Date data;


    public Publication(String title, String description) {
        this.title = title;
        this.description = description;
        this.data = Calendar.getInstance().getTime();
    }
    public Publication() {
    }

}
