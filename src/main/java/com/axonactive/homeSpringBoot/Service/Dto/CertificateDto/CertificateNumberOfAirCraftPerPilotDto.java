package com.axonactive.homeSpringBoot.Service.Dto.CertificateDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CertificateNumberOfAirCraftPerPilotDto {
    private String id;
    private long countOfAircraftCertificate;
}
