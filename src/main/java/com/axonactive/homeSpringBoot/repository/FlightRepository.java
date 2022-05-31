package com.axonactive.homeSpringBoot.repository;

import com.axonactive.homeSpringBoot.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight,String > {
}
