package com.main.App.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "contacts")
@Getter
@Setter
public class Contact {
    @Id
    @GeneratedValue
    private Long id;
    private String linkedin;
    private String instagram;
    private String telegram;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "telephone_id")
    private Telephone telephone;


    public Contact(Long id, String linkedin, String instagram, String telegram, User user, Telephone telephone) {
        this.id = id;
        this.linkedin = linkedin;
        this.instagram = instagram;
        this.telegram = telegram;
        this.user = user;
        this.telephone = telephone;
    }
}
