package com.axonactive.homeSpringBoot;

import com.axonactive.homeSpringBoot.Service.AircraftService;
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
public class AircraftServiceImplTest {
    @Autowired
    AircraftService aircraftService;

    @Test
    void testFindByDistanceGreaterThan_shouldReturn4Aircraft_whenInput1000(){
        assertEquals(4,aircraftService.findByDistanceGreaterThan(10000).size());
    }

    @Test
    void testCountByTypeContaining_shouldReturn6_whenInput747(){
        assertEquals(6,aircraftService.countByTypeContaining("Boeing"));
    }
}
