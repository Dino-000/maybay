package com.axonactive.homeSpringBoot;

import com.axonactive.homeSpringBoot.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class EmployeeServiceImplTest {
    @Autowired
    EmployeeService employeeService;

}
