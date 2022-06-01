package com.axonactive.homeSpringBoot.repository;

import com.axonactive.homeSpringBoot.entity.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AircraftRepository extends JpaRepository<Aircraft, Integer> {
  // 2.	Cho biết các loại máy bay có tầm bay lớn hơn 10,000km.
  List<Aircraft> findByDistanceGreaterThan(Integer minRange);
  // Có bao nhiêu loại máy báy Boeing.
    Integer countByTypeContaining(String containingWord);


}
