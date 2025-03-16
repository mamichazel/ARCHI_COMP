package com.example.archi_comp_wip.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Personnel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String role; // pilote, copilote, steward, hôtesse

    @ManyToOne
    @JoinColumn(name = "plane_id", nullable = false)
    private Plane plane;

    @ManyToMany(mappedBy = "personnel")
    private List<Flight> flights = new ArrayList<>();
}

