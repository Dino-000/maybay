package com.axonactive.homeSpringBoot.Service.Impl;

import com.axonactive.homeSpringBoot.Service.AircraftService;
import com.axonactive.homeSpringBoot.Service.FlightService;
import com.axonactive.homeSpringBoot.entity.Aircraft;
import com.axonactive.homeSpringBoot.entity.Flight;
import com.axonactive.homeSpringBoot.repository.AircraftRepository;
import com.axonactive.homeSpringBoot.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {
    @Autowired
    FlightRepository flightRepository;
    @Override
    public List<Flight> findByArrivalTerminal(String arrivalTerminal) {
        return flightRepository.findByArrivalTerminal(arrivalTerminal);
    }

    @Override
    public List<Flight> findByDistanceBetween(Integer minDistance, Integer maxDistance) {
        return flightRepository.findByDistanceBetween(minDistance,maxDistance);
    }

    @Override
    public List<Flight> findByArrivalTerminalAndDepartureTerminal(String arrivalTerminal, String departureTerminal) {
        return flightRepository.findByArrivalTerminalAndDepartureTerminal(arrivalTerminal, departureTerminal);
    }

    @Override
    public Integer countByDepartureTerminal(String departureTerminal) {

    return flightRepository.countByDepartureTerminal(departureTerminal);
    }
}
