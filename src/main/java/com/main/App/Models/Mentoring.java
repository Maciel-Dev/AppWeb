package com.main.App.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalTime;

@Entity
@Table(name = "mentoring")
@PrimaryKeyJoinColumn(name = "id")
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Mentoring extends Publication {
    private String discipline;
    private LocalTime duration;

}
