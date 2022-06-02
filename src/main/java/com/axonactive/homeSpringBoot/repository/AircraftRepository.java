package com.axonactive.homeSpringBoot.repository;

import com.axonactive.homeSpringBoot.entity.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AircraftRepository extends JpaRepository<Aircraft, Integer> {
  List<Aircraft> findByDistanceGreaterThan(Integer minRange);
  Integer countByTypeContaining(String containingWord);

  List<Aircraft> findByTypeContaining(String containingWord);
  List<Aircraft> findByType(String type);


}
