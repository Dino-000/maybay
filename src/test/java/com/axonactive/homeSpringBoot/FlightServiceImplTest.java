package com.axonactive.homeSpringBoot;

import com.axonactive.homeSpringBoot.Service.AircraftService;
import com.axonactive.homeSpringBoot.Service.FlightService;
import com.axonactive.homeSpringBoot.Service.Impl.FlightServiceImpl;
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
public class FlightServiceImplTest {
    @Autowired
    FlightService flightService;

    @Test
    void testFindByArrivalTerminal_shouldReturn2_whenInputDAD(){
        assertEquals(2,flightService.findByArrivalTerminal("DAD").size());
    }

    @Test
    void testFindByDistanceBetween_shouldReturn1_whenInput8000And10000(){
        assertEquals(1,flightService.findByDistanceBetween(8000,10000).size());
    }

    @Test
    void testFindByArrivalTerminalAndDepartureTerminal_shouldReturn2_whenInputSGNAndBMV(){
        assertEquals(2,flightService.findByArrivalTerminalAndDepartureTerminal("BMV","SGN").size());
    }

    @Test
    void testCountByDepartureTerminal_shouldReturn8_whenInputSGN(){
        assertEquals(8,flightService.countByDepartureTerminal("SGN"));
    }

}
