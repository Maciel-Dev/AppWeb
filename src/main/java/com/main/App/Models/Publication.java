package com.main.App.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public class Publication {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    private Date data;
    @ManyToOne
    @JoinColumn(name = "fk_perfil")
    private Perfil perfil;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "publication_topics",
            joinColumns = { @JoinColumn(name = "publication_id")},
            inverseJoinColumns = { @JoinColumn(name = "topic_id")})
    List<Topic> topics = new ArrayList<>();

    public Publication(String title, String description, Perfil perfil, List<Topic> topics) {
        this.title = title;
        this.description = description;
        this.data = Calendar.getInstance().getTime();
        this.perfil = perfil;
        this.topics = topics;
    }
    public Publication() {
    }

}
