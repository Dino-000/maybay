package com.axonactive.homeSpringBoot.Service;

import com.axonactive.homeSpringBoot.entity.Aircraft;
import com.axonactive.homeSpringBoot.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findEmployeeNotAPilot();

}
