package com.main.App.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "social_networks")
@Getter
@Setter
public class SocialNetwork {
    @Id
    @GeneratedValue
    private Long id;
    private String linkedin;
    private String instagram;
    private String telegram;
    @OneToOne
    @JoinColumn(name = "fk_perfil")
    private Perfil perfil;

    public SocialNetwork(Long id, String linkedin, String instagram, String telegram, Perfil perfil) {
        this.id = id;
        this.linkedin = linkedin;
        this.instagram = instagram;
        this.telegram = telegram;
        this.perfil = perfil;
    }
}
