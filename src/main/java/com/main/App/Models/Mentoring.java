package com.main.App.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Entity
@Table(name = "mentoring")
@PrimaryKeyJoinColumn(name = "id")
@Getter
@Setter
public class Mentoring extends Publication {
    private String discipline;
    private LocalTime duration;

    public Mentoring(String title, String description, String discipline, LocalTime duration) {
        super(title, description);
        this.discipline = discipline;
        this.duration = duration;
    }

    public Mentoring() {
        super();
    }
}
