package com.axonactive.homeSpringBoot.Service;

import com.axonactive.homeSpringBoot.entity.Aircraft;
import com.axonactive.homeSpringBoot.entity.Flight;

import java.util.List;

public interface FlightService {
    List<Flight> findByArrivalTerminal(String arrivalTerminal);
    List<Flight> findByDistanceBetween(Integer minDistance, Integer maxDistance);
    List<Flight> findByArrivalTerminalAndDepartureTerminal(String arrivalTerminal,String departureTerminal);
    Integer countByDepartureTerminal(String departureTerminal);
}
