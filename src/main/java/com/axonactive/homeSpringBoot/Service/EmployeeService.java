package com.axonactive.homeSpringBoot.Service;

import com.axonactive.homeSpringBoot.entity.Aircraft;
import com.axonactive.homeSpringBoot.entity.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> findEmployeeNotAPilot();

    String findFirstByOrderBySalaryDesc();

    Optional<Employee> findById(String id);
}
