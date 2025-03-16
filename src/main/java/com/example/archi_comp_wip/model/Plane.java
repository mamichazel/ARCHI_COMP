package com.example.archi_comp_wip.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Plane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numeroImmatriculation;
    private String modele;
    private int capacite;

    @ManyToOne
    @JoinColumn(name = "airline_id", nullable = false)
    private Airline airline;

    @OneToMany(mappedBy = "plane", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Flight> flights = new ArrayList<>();

    @OneToMany(mappedBy = "plane", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Personnel> personnel = new ArrayList<>();
}