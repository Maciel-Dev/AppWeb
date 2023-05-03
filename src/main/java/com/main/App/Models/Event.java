package com.main.App.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "event")
@PrimaryKeyJoinColumn(name = "id")
@Getter
@Setter
public class Event extends Publication {
    private LocalDateTime dateTime;
    private String type;

    public Event(String title, String description, LocalDateTime dateTime, String type) {
        super(title, description);
        this.dateTime = dateTime;
        this.type = type;
    }

    public Event() {
        super();
    }
}
