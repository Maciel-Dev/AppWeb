package com.main.App.Models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "perfils")
@NoArgsConstructor
@Getter
@Setter
public class Perfil {
    @Id
    @GeneratedValue
    private Long id;
    private String biography;
    private Date creationDate;
    private Date birthDate;
    private String gender;

    @OneToOne
    @JoinColumn(name = "fk_user")
    private User user;

    @ManyToMany(fetch = FetchType.LAZY,
        cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "perfil_topics",
        joinColumns = { @JoinColumn(name = "perfil_id")},
        inverseJoinColumns = { @JoinColumn(name = "topic_id")})
    private List<Topic> topics = new ArrayList<>();
    @OneToMany
    List <Publication> publications;

    @Builder
    public Perfil(Long id, String biography, User user, String gender) {
        this.id = id;
        this.biography = biography;
        this.gender = gender;
        this.creationDate = Calendar.getInstance().getTime();
        this.user = user;
    }

    public void removeTopic(long topicId){
        Topic topic = this.topics.stream().filter(tp -> tp.getId() == topicId).findFirst().orElse(null);
        if(topic != null){
            this.topics.remove(topic);
            topic.getPerfils().remove(this);
        }
    }

}
