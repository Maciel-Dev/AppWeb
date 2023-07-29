package com.main.App.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@AllArgsConstructor
@SuperBuilder
public class Publication {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    private Date data;
    private Long likes;
    private String image_file;
    @ManyToOne
    @JoinColumn(name = "fk_perfil")
    private Perfil perfil;

    @OneToMany(fetch = FetchType.LAZY,
              cascade = {
        CascadeType.PERSIST,
                CascadeType.MERGE
    })
    @JoinTable(name = "comment",
            joinColumns = { @JoinColumn(name = "pub_id")},
            inverseJoinColumns = { @JoinColumn(name = "comment_id")})
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "publication_topics",
            joinColumns = { @JoinColumn(name = "publication_id")},
            inverseJoinColumns = { @JoinColumn(name = "topic_id")})
    List<Topic> topics = new ArrayList<>();

    public Publication(String title, String description, List<Topic> topics) {
        this.title = title;
        this.description = description;
        this.data = Calendar.getInstance().getTime();
//        this.perfil = perfil;
        this.topics = topics;
    }
    public Publication() {
    }

}
