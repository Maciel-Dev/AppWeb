package com.main.App.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.*;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.Calendar;

@AllArgsConstructor
@Entity
@Table(name = "event")
@PrimaryKeyJoinColumn(name = "id")
@Getter
@Setter
public class Event extends Publication {
    private LocalDateTime dateTime;
    private String type;
    private Long id;

    @Builder
    public Event(String title, String description, String type) throws NoSuchFieldException {

        super(title, description);
        this.dateTime = LocalDateTime.now();
        this.type = type;
    }

    public Event() {
        super();
    }
}
