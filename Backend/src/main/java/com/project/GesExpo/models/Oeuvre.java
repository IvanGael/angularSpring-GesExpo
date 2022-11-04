package com.project.GesExpo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "oeuvres")
public class Oeuvre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(unique = true, nullable = false)
    private String Titre;

    @Column(nullable = false)
    private LocalDate DateCreation;

    @Column(nullable = false)
    private Double Prix;

    @Column(nullable = false)
    private Integer Annee;

    @Column(nullable = false)
    private String Rating;

    @Column(nullable = false)
    private String Type;

    private String Image;

    @OneToMany(mappedBy = "oeuvre", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Exposition> expositions = new ArrayList<>();



}