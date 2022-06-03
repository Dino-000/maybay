package com.axonactive.homeSpringBoot.Service.Impl;

import com.axonactive.homeSpringBoot.Service.AircraftService;
import com.axonactive.homeSpringBoot.Service.EmployeeService;
import com.axonactive.homeSpringBoot.entity.Aircraft;
import com.axonactive.homeSpringBoot.entity.Employee;
import com.axonactive.homeSpringBoot.repository.AircraftRepository;
import com.axonactive.homeSpringBoot.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findEmployeeNotAPilot() {
        return employeeRepository.findEmployeeNotAPilot();
    }
}
