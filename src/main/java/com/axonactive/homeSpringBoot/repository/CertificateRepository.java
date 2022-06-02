package com.axonactive.homeSpringBoot.repository;

import com.axonactive.homeSpringBoot.entity.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CertificateRepository extends JpaRepository<Certificate, Integer> {
    //11.	Cho biết mã số của các loại máy bay mà nhân viên có họ Nguyễn có thể lái.
    @Query(nativeQuery = true,value = "SELECT DISTINCT aircraft_id " +
            "FROM certificates " +
            "WHERE employee_id IN (SELECT id FROM employee WHERE name LIKE :name%) ")
    List<String> findByEmployeeName(@Param("name") String name);

    //12.	Cho biết mã số của các phi công vừa lái được Boeing vừa lái được Airbus.
    @Query(nativeQuery = true,value="SELECT c.employee_id FROM certificates AS c WHERE c.aircraft_id IN (SELECT id FROM aircraft WHERE type LIKE 'Boeing%') ")
    List<String> dangTestBoeingNha();

    @Query(nativeQuery = true,value="SELECT c.employee_id FROM certificates AS c WHERE c.aircraft_id IN (SELECT id FROM aircraft WHERE LEFT(type,6) = 'Airbus') ")
    List<String> dangTestAirBusNha();

    @Query(nativeQuery = true,value="SELECT c.employee_id FROM certificates AS c WHERE c.aircraft_id IN (SELECT id FROM aircraft WHERE type LIKE :airCraftName1%) " +
            "INTERSECT " +
            "SELECT c.employee_id FROM certificates AS c WHERE c.aircraft_id IN (SELECT id FROM aircraft WHERE type LIKE :airCraftName2%) ")
    List<String> dangTestAirBusVaBoeingNha(@Param("airCraftName1") String airCraftName1,@Param("airCraftName2") String airCraftName2);



    List<Certificate> findByAircraftTypeContaining(String containingWord);
}
