package com.main.App.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "event")
@PrimaryKeyJoinColumn(name = "id")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Event extends Publication {
    private LocalDateTime dateTime;
    private String type;

}
