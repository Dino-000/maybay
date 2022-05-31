package com.axonactive.homeSpringBoot.repository;

import com.axonactive.homeSpringBoot.entity.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AircraftRepository extends JpaRepository<Aircraft, Integer> {
}
