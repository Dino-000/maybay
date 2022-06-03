package com.axonactive.homeSpringBoot.repository;

import com.axonactive.homeSpringBoot.Service.Dto.CertificateDto.CertificateMaxAircraftRangeOfPilotCanUseMoreThan3AircraftDto;
import com.axonactive.homeSpringBoot.Service.Dto.CertificateDto.CertificateNumberOfAirCraftPerPilotDto;
import com.axonactive.homeSpringBoot.entity.Certificate;
import com.axonactive.homeSpringBoot.entity.Employee;
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
    Integer countByEmployee(Employee employee);

  @Query(
      value =
          "select new com.axonactive.homeSpringBoot.Service.Dto.CertificateDto.CertificateMaxAircraftRangeOfPilotCanUseMoreThan3AircraftDto(c.employee.id, max(c.aircraft.distance)) "
              + "from Certificate c "
              + "where c.employee.id in (select c.employee.id "
              + "from Certificate c "
              + "group by c.employee.id "
              + "having count(c.employee.id)> 3) "
              + "group by c.employee.id")
  List<CertificateMaxAircraftRangeOfPilotCanUseMoreThan3AircraftDto>
      findMaxDistanceOfEmployeeCanUseMoreThan3AirCrafts();

  @Query(value = "SELECT new com.axonactive.homeSpringBoot.Service.Dto.CertificateDto.CertificateNumberOfAirCraftPerPilotDto(c.employee.id, COUNT(c.aircraft)) " +
          "FROM Certificate c " +
          "GROUP BY c.employee.id " +
          "ORDER BY COUNT(c.aircraft) DESC")
    List<CertificateNumberOfAirCraftPerPilotDto> findNumberOfAircraftPerPilot();
}
