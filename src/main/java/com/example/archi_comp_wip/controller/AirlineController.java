package com.example.archi_comp_wip.controller;

import com.example.archi_comp_wip.model.Airline;
import com.example.archi_comp_wip.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/airlines")
public class AirlineController {

    @Autowired
    private AirlineService airlineService;

    // 📌 Récupérer toutes les compagnies aériennes
    @GetMapping
    public List<Airline> getAllAirlines() {
        return airlineService.getAllAirlines();
    }

    // 📌 Récupérer une compagnie aérienne par ID
    @GetMapping("/{id}")
    public Optional<Airline> getAirlineById(@PathVariable Long id) {
        return airlineService.getAirlineById(id);
    }

    // 📌 Ajouter une compagnie aérienne
    @PostMapping
    public Airline createAirline(@RequestBody Airline airline) {
        return airlineService.createAirline(airline);
    }

    // 📌 Supprimer une compagnie aérienne
    @DeleteMapping("/{id}")
    public void deleteAirline(@PathVariable Long id) {
        airlineService.deleteAirline(id);
    }
}
