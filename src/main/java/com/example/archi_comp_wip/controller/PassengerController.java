package com.example.archi_comp_wip.controller;

import com.example.archi_comp_wip.model.Passenger;
import com.example.archi_comp_wip.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/passengers")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    // 📌 Récupérer tous les passagers
    @GetMapping
    public List<Passenger> getAllPassengers() {
        return passengerService.getAllPassengers();
    }

    // 📌 Récupérer un passager par ID
    @GetMapping("/{id}")
    public Optional<Passenger> getPassengerById(@PathVariable Long id) {
        return passengerService.getPassengerById(id);
    }

    // 📌 Ajouter un passager
    @PostMapping
    public Passenger createPassenger(@RequestBody Passenger passenger) {
        return passengerService.createPassenger(passenger);
    }

    // 📌 Mettre à jour un passager
    @PutMapping("/{id}")
    public Passenger updatePassenger(@PathVariable Long id, @RequestBody Passenger updatedPassenger) {
        return passengerService.updatePassenger(id, updatedPassenger);
    }

    // 📌 Supprimer un passager
    @DeleteMapping("/{id}")
    public void deletePassenger(@PathVariable Long id) {
        passengerService.deletePassenger(id);
    }
}
