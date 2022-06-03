package com.axonactive.homeSpringBoot.Service.Dto.CertificateDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CertificateMaxAircraftRangeOfPilotCanUseMoreThan3AircraftDto {
    private String EmployeeId;
    private Integer maxRangeOfAircraftCanUse;
}
