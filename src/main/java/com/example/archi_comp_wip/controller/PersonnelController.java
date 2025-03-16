package com.example.archi_comp_wip.controller;

import com.example.archi_comp_wip.model.Personnel;
import com.example.archi_comp_wip.service.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/personnel")
public class PersonnelController {

    @Autowired
    private PersonnelService personnelService;

    // 📌 Récupérer tous les membres du personnel
    @GetMapping
    public List<Personnel> getAllPersonnel() {
        return personnelService.getAllPersonnel();
    }

    // 📌 Récupérer un membre du personnel par ID
    @GetMapping("/{id}")
    public Optional<Personnel> getPersonnelById(@PathVariable Long id) {
        return personnelService.getPersonnelById(id);
    }

    // 📌 Ajouter un membre du personnel
    @PostMapping
    public Personnel createPersonnel(@RequestBody Personnel personnel) {
        return personnelService.createPersonnel(personnel);
    }

    // 📌 Supprimer un membre du personnel
    @DeleteMapping("/{id}")
    public void deletePersonnel(@PathVariable Long id) {
        personnelService.deletePersonnel(id);
    }
}
