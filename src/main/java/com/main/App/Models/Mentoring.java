package com.main.App.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalTime;

@Entity
@Table(name = "mentoring")
@PrimaryKeyJoinColumn(name = "id")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Mentoring extends Publication {
    private String discipline;
    private LocalTime duration;

}
