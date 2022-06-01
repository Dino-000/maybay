package com.axonactive.homeSpringBoot.Service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CertificateService {
    @Query(nativeQuery = true,value = "SELECT DISTINCT aircraft_id " +
            "FROM certificate " +
            "WHERE employee_id IN (SELECT id FROM employee WHERE name LIKE :name%) ")
    List<String> findByEmployeeNameIsNguyen(@Param("name") String name);

    List<String> dangTestBoeingNha();
    List<String> dangTestAirBusNha();
    List<String> dangTestAirBusVaBoeingNha();

}
