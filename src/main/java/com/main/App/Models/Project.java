package com.main.App.Models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "projects")
@PrimaryKeyJoinColumn(name = "id")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Project extends Publication {
    private String theme;
    private int participants;

    @Builder
    public Project(String title, String description, Perfil perfil, String theme, int participants) {
        super(title, description, perfil);
        this.theme = theme;
        this.participants = participants;
    }
}
