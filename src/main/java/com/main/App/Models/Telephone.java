package com.main.App.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "phones")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Telephone {
    @Id
    @GeneratedValue
    private Long id;
    private Short ddd;
    private Integer number;

    @OneToOne
    @JoinColumn(name = "fk_perfil")
    private Perfil perfil;

}
