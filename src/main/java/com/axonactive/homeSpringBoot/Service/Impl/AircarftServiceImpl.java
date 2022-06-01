package com.axonactive.homeSpringBoot.Service.Impl;

import com.axonactive.homeSpringBoot.Service.AircraftService;
import com.axonactive.homeSpringBoot.entity.Aircraft;
import com.axonactive.homeSpringBoot.repository.AircraftRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AircarftServiceImpl implements AircraftService {
    @Autowired
    private final AircraftRepository aircraftRepository;

    @Override
    public List<Aircraft> findByDistanceGreaterThan(Integer minRange) {
        return aircraftRepository.findByDistanceGreaterThan(minRange);
    }

    @Override
    public Integer countByTypeContaining(String containingWord) {
        return aircraftRepository.countByTypeContaining(containingWord);

    }
}
