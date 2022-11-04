package com.project.GesExpo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "expositions")
public class Exposition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(unique = true, nullable = false)
    private String Titre;

    @Column(nullable = false)
    private Integer Etat;

    @Column(nullable = false)
    private LocalDate DateExpo;

    @Column(nullable = false)
    private Integer Duree;

    @ManyToOne
    @JoinColumn(name = "sessionId")
    private Session session;

    @ManyToOne
    @JoinColumn(name = "oeuvreId")
    private Oeuvre oeuvre;
}