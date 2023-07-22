package com.main.App.Models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Table(name = "projects")
@PrimaryKeyJoinColumn(name = "id")
@SuperBuilder
@AllArgsConstructor
@Getter
@Setter
public class Project extends Publication {
    private String theme;
    private int participants;
    private String type;

    public Project() {

    }

}
