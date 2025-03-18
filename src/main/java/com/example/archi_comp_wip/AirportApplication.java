package com.example.archi_comp_wip;

import com.example.archi_comp_wip.model.*;
import com.example.archi_comp_wip.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class AirportApplication implements CommandLineRunner {

    @Autowired
    private FlightService flightService;

    @Autowired
    private PassengerService passengerService;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private PlaneService planeService;

    @Autowired
    private AirlineService airlineService;

    public static void main(String[] args) {
        SpringApplication.run(AirportApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        generateFlightsAndTickets(10);
    }

    private void generateFlightsAndTickets(int numberOfFlights) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        String[] airlines = {"Air France", "Lufthansa", "KLM", "Emirates"};
        String[] planeModels = {"Boeing 737", "Airbus A320", "Boeing 787", "Airbus A350"};
        String[] flightStatuses = {"prévu", "retardé", "annulé"};

        Random random = new Random();

        // Créer des compagnies et des avions de manière aléatoire
        List<Airline> createdAirlines = new ArrayList<>();
        for (String airlineName : airlines) {
            Airline airline = new Airline();
            airline.setNom(airlineName);
            createdAirlines.add(airlineService.createAirline(airline));
        }

        // Créer des vols, passagers, et tickets
        for (int i = 0; i < numberOfFlights; i++) {
            Airline airline = createdAirlines.get(random.nextInt(createdAirlines.size()));

            // Créer un avion pour la compagnie choisie
            Plane plane = new Plane();
            plane.setModele(planeModels[random.nextInt(planeModels.length)]);
            plane.setCapacite(150 + random.nextInt(100));
            plane.setAirline(airline);
            plane = planeService.createPlane(plane);


            Flight flight = new Flight();
            flight.setNumeroVol(airline.getNom().substring(0, 2).toUpperCase() + (100 + i));
            flight.setDateDepart(LocalDateTime.now().plusDays(random.nextInt(30)).withHour(8 + random.nextInt(4)).withMinute(random.nextInt(60)));
            flight.setDateArrivee(flight.getDateDepart().plusHours(2 + random.nextInt(4)));
            flight.setStatut(flightStatuses[random.nextInt(flightStatuses.length)]);
            flight.setPlane(plane);
            flight.setAirline(airline);
            flightService.createFlight(flight);

            // Créer des passagers et des tickets
            for (int j = 0; j < 3; j++) {  // 3 passagers par vol
                Passenger passenger = new Passenger();
                passenger.setNom("Nom" + random.nextInt(1000));
                passenger.setPrenom("Prenom" + random.nextInt(1000));
                passenger.setEmail("email" + random.nextInt(1000) + "@example.com");
                passenger = passengerService.createPassenger(passenger);

                Ticket ticket = new Ticket();
                ticket.setNumeroTicket("TICKET" + (1000 + j));
                ticket.setClasse(random.nextBoolean() ? "économique" : "affaires");
                ticket.setPrix(150.0 + random.nextInt(350));
                ticket.setPassenger(passenger);
                ticket.setFlight(flight);
                ticketService.createTicket(ticket);
            }
        }

    }
}
