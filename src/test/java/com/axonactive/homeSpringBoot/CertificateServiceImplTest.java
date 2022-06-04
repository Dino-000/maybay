package com.axonactive.homeSpringBoot;

import com.axonactive.homeSpringBoot.Service.CertificateService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class CertificateServiceImplTest {
    @Autowired
    CertificateService certificateService;


//11.	Cho biết mã số của các loại máy bay mà nhân viên có họ Nguyễn có thể lái.
    @Test
    void testCertificateService_shouldReturn7_whenInputNguyen(){
        assertEquals(7,certificateService.findByEmployeeNameIsNguyen("Nguyen").size());
    }

    @Test
    void testDangTestBoeingNha(){
        assertEquals(28,certificateService.dangTestBoeingNha().size());
    }

    @Test
    void testDangTestAirBusNha(){
        assertEquals(11,certificateService.dangTestAirBusNha().size());
    }

    //12.	Cho biết mã số của các phi công vừa lái được Boeing vừa lái được Airbus.
    @Test
    void testDangTestAirBusVaBoeingNha(){
        assertEquals(4,certificateService.dangTestAirBusVaBoeingNha("Boeing","Airbus").size());
    }
    //15.	Cho biết tên của các phi công lái máy bay Boeing.
    @Test
    void testFindByAircraftTypeContaining_shouldReturn28_WhenInputBoeing(){
        assertEquals(28,certificateService.findByAircraftTypeContaining("Boeing").size());
    }

    //16.	Với mỗi loại máy bay có phi công lái cho biết mã số, loại máy báy và tổng số phi công có thể lái loại máy bay đó.
    @Test
    void testCountNumberOfEmployeeCanDriveSpecificAircraft_shouldReturn10_WhenCalled(){
        assertEquals(10,certificateService.countNumberOfEmployeeCanDriveSpecificAircraft().size());
        assertEquals(4,certificateService.countNumberOfEmployeeCanDriveSpecificAircraft().get("Airbus A320"));
    }

    //22.	Cho biết mã số của các phi công chỉ lái được 3 loại máy bay
    @Test
    void testFindByCountCertificate_shouldReturn2_whenCheckSize() {
        assertEquals(2,certificateService.findByCountCertificate(3).size());

    }

    //23 Với mỗi phi công có thể lái nhiều hơn 3 loại máy bay, cho biết mã số phi công và tầm bay lớn nhất của các loại máy bay mà phi công đó có thể lái.
    @Test
    void testFindMaxDistanceOfEmployeeCanUseMoreThanANumberAirCraft_shouldReturn4_WhenCheckSize(){
        assertEquals(4,certificateService.findMaxDistanceOfEmployeeCanUseMoreThanANumberAirCraft().size());
    }

    //24.	Với mỗi phi công cho biết mã số phi công và tổng số loại máy bay mà phi công đó có thể lái.
    @Test
    void testFindNumberOfAircraftPerPilot_shouldReturn12_whenCheckSize(){
        assertEquals(12,certificateService.findNumberOfAircraftPerPilot().size());
        assertEquals(10,certificateService.findNumberOfAircraftPerPilot().get(0).getCountOfAircraftCertificate());
        assertEquals(7,certificateService.findNumberOfAircraftPerPilot().get(1).getCountOfAircraftCertificate());
    }

    //--27. Cho biết tổng số lương phải trả cho các phi công.
    @Test
    void testFindSumPilotSalary_shouldReturn2064793_whenCall(){
        assertEquals(2064793,certificateService.findSumPilotSalary());
    }



}
