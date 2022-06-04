package com.axonactive.homeSpringBoot.Service.Impl;

import com.axonactive.homeSpringBoot.Service.AircraftService;
import com.axonactive.homeSpringBoot.Service.FlightService;
import com.axonactive.homeSpringBoot.entity.Flight;
import com.axonactive.homeSpringBoot.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {
  @Autowired FlightRepository flightRepository;
  @Autowired AircraftService aircraftService;

  @Override
  public List<Flight> findByArrivalTerminal(String arrivalTerminal) {
    return flightRepository.findByArrivalTerminal(arrivalTerminal);
  }

  @Override
  public List<Flight> findByDistanceBetween(Integer minDistance, Integer maxDistance) {
    return flightRepository.findByDistanceBetween(minDistance, maxDistance);
  }

  @Override
  public List<Flight> findByArrivalTerminalAndDepartureTerminal(
      String arrivalTerminal, String departureTerminal) {
    return flightRepository.findByArrivalTerminalAndDepartureTerminal(
        arrivalTerminal, departureTerminal);
  }

  @Override
  public Integer countByDepartureTerminal(String departureTerminal) {

    return flightRepository.countByDepartureTerminal(departureTerminal);
  }

  @Override
  public Optional<Flight> findById(String id) {
    return flightRepository.findById(id);
  }

  @Override
  public List<Flight> findBySpecificAircraftCanExecute(String aircraftType) {
    return flightRepository.findByDistanceLessThan(
        aircraftService.findByType(aircraftType).get(0).getDistance());
  }

  @Override
  public List<Flight> findRoundTripFlight() {
    List<Flight> roundTripFlight = new ArrayList<>();
    List<Flight> listOfFlights = flightRepository.findAll();
    System.out.println(listOfFlights.size() + "hehehe");
    for (Flight flight : listOfFlights) {
      for (Flight checkingFlight : listOfFlights) {
        if (flight.getArrivalTerminal().equals(checkingFlight.getDepartureTerminal())
            && flight.getDepartureTerminal().equals(checkingFlight.getArrivalTerminal())) {

          roundTripFlight.add(flight);
        }
      }
    }
    return roundTripFlight;
  }

  @Override
  public Map<String, Integer> countFlightPerTerminal() {
    Map<String, Integer> flightPerTerminal = new HashMap<>();
    List<Flight> listOfFlights = flightRepository.findAll();
    for(Flight flight :listOfFlights){
      String currentFlightDepartureTerminal = flight.getDepartureTerminal();
      if (flightPerTerminal.containsKey(currentFlightDepartureTerminal)){
        flightPerTerminal.put(currentFlightDepartureTerminal,flightPerTerminal.get(currentFlightDepartureTerminal)+1);
      } else {
        flightPerTerminal.put(currentFlightDepartureTerminal, 1);
      }
    }
    return flightPerTerminal;
  }

  @Override
  public Map<String, Double> sumPilotSalaryPerTerminal() {
    Map<String, Double> pilotSalaryPerTerminal = new HashMap<>();
    List<Flight> listOfFlights = flightRepository.findAll();
    for(Flight flight :listOfFlights){
      String currentFlightDepartureTerminal = flight.getDepartureTerminal();
      if (pilotSalaryPerTerminal.containsKey(currentFlightDepartureTerminal)){
        pilotSalaryPerTerminal.put(currentFlightDepartureTerminal,pilotSalaryPerTerminal.get(currentFlightDepartureTerminal) + flight.getPrice());
      } else {
        pilotSalaryPerTerminal.put(currentFlightDepartureTerminal, flight.getPrice());
      }
    }
    return pilotSalaryPerTerminal;
  }

  @Override
  public List<Flight> findByDepartureTimeBefore(LocalTime time) {
    return flightRepository.findByDepartureTimeBefore(time);
  }

  @Override
  public Map<String, Integer> countFlightPerDepartureTerminal() {
    Map<String, Integer> flightPerDepartureTerminal = new HashMap<>();
    List<Flight> listOfFlights = flightRepository.findAll();
    for(Flight flight:listOfFlights){
      String currentDeparture = flight.getDepartureTerminal();
      if(flightPerDepartureTerminal.containsKey(currentDeparture) &&
              flight.getDepartureTime().isBefore(LocalTime.parse("12:00:00"))){
        flightPerDepartureTerminal.put(currentDeparture,flightPerDepartureTerminal.get(currentDeparture)+1);
      } else if (flight.getDepartureTime().isBefore(LocalTime.parse("12:00:00")) &&
              !flightPerDepartureTerminal.containsKey(currentDeparture)){
        flightPerDepartureTerminal.put(currentDeparture,1);
      }
    }
    return flightPerDepartureTerminal;
  }

  @Override
  public List<Flight> findByAllBoeingCanExecute() {
    return flightRepository.findByAllBoeingCanExecute();
  }


}
