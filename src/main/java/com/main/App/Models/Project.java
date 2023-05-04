package com.main.App.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "projects")
@PrimaryKeyJoinColumn(name = "id")
@Getter
@Setter
public class Project extends Publication {
    private String theme;
    private int participants;

    public Project(String title, String description, String theme, int participants) {
        super(title, description);
        this.theme = theme;
        this.participants = participants;
    }

    public Project() {
        super();
    }
}
