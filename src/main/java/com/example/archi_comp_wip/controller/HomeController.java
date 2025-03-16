package com.example.archi_comp_wip.controller;

import com.example.archi_comp_wip.model.Flight;
import com.example.archi_comp_wip.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private FlightService flightService;

    @GetMapping("/")
    public String home(Model model) {
        List<Flight> flights = flightService.getAllFlights();
        if (flights == null || flights.isEmpty()) {
            System.out.println("Aucun vol trouvé");
        } else {
            System.out.println("Vols récupérés : " + flights.size());
        }
        model.addAttribute("flights", flights);
        return "Home";
    }

}