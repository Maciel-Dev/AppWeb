package com.main.App.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "topics")
@Getter
@Setter
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    public Topic(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "topics")
    @JsonIgnore
    private List <Perfil> perfils = new ArrayList<>();

    public Topic(){}

    public Topic(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
