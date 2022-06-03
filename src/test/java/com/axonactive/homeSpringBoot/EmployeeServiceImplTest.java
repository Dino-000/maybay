package com.axonactive.homeSpringBoot;

import com.axonactive.homeSpringBoot.Service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class EmployeeServiceImplTest {
    @Autowired
    EmployeeService employeeService;

    //Tìm các nhân viên không phải là phi công.
    @Test
    void testFindEmployeeNotAPilot_shouldReturn12_whenCheckSize (){
        assertEquals(12, employeeService.findEmployeeNotAPilot().size());
    }

    //Cho biết mã số của các nhân viên có lương cao nhất.
    @Test
    void testFindBy

}
