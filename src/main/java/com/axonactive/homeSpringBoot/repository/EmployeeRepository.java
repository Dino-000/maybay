package com.axonactive.homeSpringBoot.repository;

import com.axonactive.homeSpringBoot.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {
    //3.	Tìm các nhân viên có lương nhỏ hơn 10,000.
    List<Employee> findBySalaryLessThan(Integer minSalary);

    @Query(value="SELECT e " +
            "FROM Employee e " +
//            "EXCEPT " +
//            "SELECT c.employee " +
//            "FROM Certificate c")
            "WHERE e.id NOT IN ( SELECT c.employee.id " +
            "FROM Certificate c )")
    List<Employee> findEmployeeNotAPilot();

    Employee findFirstByOrderBySalaryDesc();

}
