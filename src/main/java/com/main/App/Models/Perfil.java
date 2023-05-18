package com.main.App.Models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;
import java.util.Date;

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

    @OneToOne
    @JoinColumn(name = "fk_user")
    private User user;

    @Builder
    public Perfil(Long id, String biography, User user) {
        this.id = id;
        this.biography = biography;
        this.creationDate = Calendar.getInstance().getTime();
        this.user = user;
    }



}
