package com.axonactive.homeSpringBoot.Service;

import com.axonactive.homeSpringBoot.Service.Dto.CertificateDto.CertificateMaxAircraftRangeOfPilotCanUseMoreThan3AircraftDto;
import com.axonactive.homeSpringBoot.Service.Dto.CertificateDto.CertificateNumberOfAirCraftPerPilotDto;
import com.axonactive.homeSpringBoot.entity.Aircraft;
import com.axonactive.homeSpringBoot.entity.Certificate;
import com.axonactive.homeSpringBoot.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

public interface CertificateService {

    List<String> findByEmployeeNameIsNguyen(@Param("name") String name);

    List<String> dangTestBoeingNha();
    List<String> dangTestAirBusNha();
    List<String> dangTestAirBusVaBoeingNha(String airCraftName1, String airCraftName2);
    List<Certificate> findByAircraftTypeContaining(String containingWord);
    Map<String,Integer> countNumberOfEmployeeCanDriveSpecificAircraft ();
    HashSet<Employee> findByCountCertificate(Integer number);
    Integer countByEmployee(Employee employee);
    List<CertificateMaxAircraftRangeOfPilotCanUseMoreThan3AircraftDto> findMaxDistanceOfEmployeeCanUseMoreThanANumberAirCraft ();


    List <CertificateNumberOfAirCraftPerPilotDto> findNumberOfAircraftPerPilot();
}
