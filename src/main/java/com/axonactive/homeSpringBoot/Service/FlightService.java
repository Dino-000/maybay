package com.axonactive.homeSpringBoot.Service;

import com.axonactive.homeSpringBoot.entity.Aircraft;
import com.axonactive.homeSpringBoot.entity.Flight;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface FlightService {
    List<Flight> findByArrivalTerminal(String arrivalTerminal);
    List<Flight> findByDistanceBetween(Integer minDistance, Integer maxDistance);
    List<Flight> findByArrivalTerminalAndDepartureTerminal(String arrivalTerminal,String departureTerminal);
    Integer countByDepartureTerminal(String departureTerminal);
    Optional<Flight> findById(String id);

    List<Flight> findBySpecificAircraftCanExecute(String aircraftType);
    List<Flight> findRoundTripFlight();

    Map<String, Integer> countFlightPerTerminal();

    Map<String, Double> sumPilotSalaryPerTerminal();

    List<Flight> findByDepartureTimeBefore(LocalTime time);
    Map<String,Integer> countFlightPerDepartureTerminal();
}
