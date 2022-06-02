package com.axonactive.homeSpringBoot.Service;

import com.axonactive.homeSpringBoot.entity.Aircraft;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface AircraftService {
    List<Aircraft> findByDistanceGreaterThan(Integer minRange);
    Integer countByTypeContaining(String containingWord);
    List<Aircraft> findByTypeContaining (String containingWord);
    Set<String> findAircraftTypeAvailableForSpecificFlight (String flightName);


    List<Aircraft> findByType(String aircraftType);
}
