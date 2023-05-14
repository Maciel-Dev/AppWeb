package com.main.App.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "telephone")
@Getter
@Setter
public class Telephone {
    @Id
    @GeneratedValue
    private Long id;
    private Short ddd;
    private Integer number;

    public Telephone(Short ddd, Integer number) {
        this.ddd = ddd;
        this.number = number;
    }

    public Telephone() {}
}
