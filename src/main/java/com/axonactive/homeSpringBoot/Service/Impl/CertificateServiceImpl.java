package com.axonactive.homeSpringBoot.Service.Impl;

import com.axonactive.homeSpringBoot.Service.CertificateService;
import com.axonactive.homeSpringBoot.entity.Certificate;
import com.axonactive.homeSpringBoot.repository.CertificateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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


    public Set<String> findNameByAircraftTypeContaining(String containingWord) {
        Set<String> nameCanUseBoeing= new HashSet<>();
        for(Certificate certificate:findByAircraftTypeContaining(containingWord)){
            nameCanUseBoeing.add(certificate.getEmployee().getName());
        }
        return nameCanUseBoeing;
    }
}
