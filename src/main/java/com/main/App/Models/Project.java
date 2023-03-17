package com.main.App.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "projects")
@Getter
@Setter
public class Project extends Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String theme;
    private Integer participants;

    public Project(String title, String description, String theme, Integer participants){
        super(title, description);
        this.theme = theme;
        this.participants = participants;
    }
}
