package com.main.App.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "event")
@PrimaryKeyJoinColumn(name = "id")
@SuperBuilder
@AllArgsConstructor
@Getter
@Setter
public class Event extends Publication {
    private LocalDateTime dateTime;
    private String type;

    public Event() {

    }
}
