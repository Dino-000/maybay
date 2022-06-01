package com.axonactive.homeSpringBoot.repository;

import com.axonactive.homeSpringBoot.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
    //3.	Tìm các nhân viên có lương nhỏ hơn 10,000.
    List<Employee> findBySalaryLessThan(Integer minSalary);
}
