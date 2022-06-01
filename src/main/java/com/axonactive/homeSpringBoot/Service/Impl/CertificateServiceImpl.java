package com.axonactive.homeSpringBoot.Service.Impl;

import com.axonactive.homeSpringBoot.Service.CertificateService;
import com.axonactive.homeSpringBoot.repository.CertificateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CertificateServiceImpl implements CertificateService {

    @Autowired
    CertificateRepository certificateRepository;

    @Override
    public List<String> findByEmployeeNameIsNguyen(String name) {
        return certificateRepository.findByEmployeeNameIsNguyen(name);
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
    public List<String> dangTestAirBusVaBoeingNha() {
        return certificateRepository.dangTestAirBusVaBoeingNha();
    }
}
