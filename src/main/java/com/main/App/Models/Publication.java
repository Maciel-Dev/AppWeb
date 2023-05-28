package com.main.App.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private Date data;
    @ManyToOne
    @JoinColumn(name = "fk_perfil")
    private Perfil perfil;

    public Publication(String title, String description, Perfil perfil) {
        this.title = title;
        this.description = description;
        this.data = Calendar.getInstance().getTime();
        this.perfil = perfil;
    }
    public Publication() {
    }

}
