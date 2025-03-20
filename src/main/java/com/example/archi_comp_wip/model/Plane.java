package com.example.archi_comp_wip.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
/*@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")*/
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
    @JsonIgnore
    private List<Flight> flights = new ArrayList<>();

    @OneToMany(mappedBy = "plane", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore //Sert a eviter
    private List<Personnel> personnel = new ArrayList<>();
}