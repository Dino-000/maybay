package com.axonactive.homeSpringBoot.Service.Impl;

import com.axonactive.homeSpringBoot.Service.AircraftService;
import com.axonactive.homeSpringBoot.Service.FlightService;
import com.axonactive.homeSpringBoot.entity.Aircraft;
import com.axonactive.homeSpringBoot.repository.AircraftRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AircraftServiceImpl implements AircraftService {
    @Autowired
    private  AircraftRepository aircraftRepository;

    @Autowired
    private FlightService flightService;

    @Override
    public List<Aircraft> findByDistanceGreaterThan(Integer minRange) {
        return aircraftRepository.findByDistanceGreaterThan(minRange);
    }

    @Override
    public Integer countByTypeContaining(String containingWord) {
        return aircraftRepository.countByTypeContaining(containingWord);

    }

    @Override
    public List<Aircraft> findByTypeContaining(String containingWord) {
        return aircraftRepository.findByTypeContaining(containingWord);
    }

    @Override
    public Set<String> findAircraftTypeAvailableForSpecificFlight(String flightId) {

        return geTypeOfAListOfAircraft(findByDistanceGreaterThan(flightService.findById(flightId).get().getDistance()));
    }

    @Override
    public List<Aircraft> findByType(String aircraftType) {
        return aircraftRepository.findByType(aircraftType);
    }

    public Set<String> geTypeOfAListOfAircraft(List<Aircraft> list){
        HashSet<String> aircraftName = new HashSet<>();
        for(Aircraft aircraft:list){
            aircraftName.add(aircraft.getType());
        }
        return aircraftName;
    }

}
