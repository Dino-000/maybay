package com.axonactive.homeSpringBoot.Service;

import com.axonactive.homeSpringBoot.entity.Aircraft;

import java.util.List;

public interface AircraftService {
    List<Aircraft> findByDistanceGreaterThan(Integer minRange);
    Integer countByTypeContaining(String containingWord);

}
