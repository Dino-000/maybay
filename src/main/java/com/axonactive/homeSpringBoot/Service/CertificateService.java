package com.axonactive.homeSpringBoot.Service;

import com.axonactive.homeSpringBoot.entity.Certificate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CertificateService {

    List<String> findByEmployeeNameIsNguyen(@Param("name") String name);

    List<String> dangTestBoeingNha();
    List<String> dangTestAirBusNha();
    List<String> dangTestAirBusVaBoeingNha(String airCraftName1, String airCraftName2);
    List<Certificate> findByAircraftTypeContaining(String containingWord);


}
