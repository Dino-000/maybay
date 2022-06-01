package com.axonactive.homeSpringBoot;

import com.axonactive.homeSpringBoot.Service.CertificateService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class CertificateServiceImplTest {
    @Autowired
    CertificateService certificateService;

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

    @Test
    void testDangTestAirBusVaBoeingNha(){
        assertEquals(4,certificateService.dangTestAirBusVaBoeingNha().size());
    }


}
