package com.axonactive.homeSpringBoot.Service.Impl;

import com.axonactive.homeSpringBoot.Service.CertificateService;
import com.axonactive.homeSpringBoot.Service.Dto.CertificateDto.CertificateMaxAircraftRangeOfPilotCanUseMoreThan3AircraftDto;
import com.axonactive.homeSpringBoot.Service.Dto.CertificateDto.CertificateNumberOfAirCraftPerPilotDto;
import com.axonactive.homeSpringBoot.entity.Aircraft;
import com.axonactive.homeSpringBoot.entity.Certificate;
import com.axonactive.homeSpringBoot.entity.Employee;
import com.axonactive.homeSpringBoot.repository.CertificateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class CertificateServiceImpl implements CertificateService {

    @Autowired
    CertificateRepository certificateRepository;

    @Override
    public List<String> findByEmployeeNameIsNguyen(String name) {
        return certificateRepository.findByEmployeeName(name);
    }

    @Override
    public List<String> dangTestBoeingNha() {
        return certificateRepository.dangTestBoeingNha();
    }

    @Override
    public List<String> dangTestAirBusNha() {
        return certificateRepository.dangTestAirBusNha();
    }

    @Override
    public List<String> dangTestAirBusVaBoeingNha(String airCraftName1, String airCraftName2) {
        return certificateRepository.dangTestAirBusVaBoeingNha(airCraftName1,airCraftName2);
    }

    @Override
    public List<Certificate> findByAircraftTypeContaining(String containingWord) {
        return certificateRepository.findByAircraftTypeContaining(containingWord);
    }

    @Override
    public Map<String, Integer> countNumberOfEmployeeCanDriveSpecificAircraft() {
        Map<String, Integer> pilotPerAircraft = new HashMap<>();
        for(Certificate certificate: certificateRepository.findAll()){
            String currentAircraftType= certificate.getAircraft().getType();
            if(pilotPerAircraft.containsKey(currentAircraftType)){
                pilotPerAircraft.put(currentAircraftType,pilotPerAircraft.get(currentAircraftType)+1);
            } else{
                pilotPerAircraft.put(currentAircraftType,1);
            }
        }
        return pilotPerAircraft;
    }

    @Override
    public HashSet<Employee> findByCountCertificate(Integer number) {
        HashSet<Employee> certificatePerEmp = new HashSet<Employee>();
        for(Certificate certificate: certificateRepository.findAll()){
            Employee currentEmp = certificate.getEmployee();
            if(countByEmployee(currentEmp)==number){
                certificatePerEmp.add(currentEmp);
            }
        }
        return certificatePerEmp;
    }

    @Override
    public Integer countByEmployee(Employee employee) {
        return certificateRepository.countByEmployee(employee);
    }

    @Override
    public List<CertificateMaxAircraftRangeOfPilotCanUseMoreThan3AircraftDto> findMaxDistanceOfEmployeeCanUseMoreThanANumberAirCraft() {
        return certificateRepository.findMaxDistanceOfEmployeeCanUseMoreThan3AirCrafts();
    }

    @Override
    public List<CertificateNumberOfAirCraftPerPilotDto> findNumberOfAircraftPerPilot() {
        return certificateRepository.findNumberOfAircraftPerPilot();
    }


    public Set<String> findNameByAircraftTypeContaining(String containingWord) {
        Set<String> nameCanUseBoeing= new HashSet<>();
        for(Certificate certificate:findByAircraftTypeContaining(containingWord)){
            nameCanUseBoeing.add(certificate.getEmployee().getName());
        }
        return nameCanUseBoeing;
    }
}
