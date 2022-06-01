package com.axonactive.homeSpringBoot.repository;

import com.axonactive.homeSpringBoot.entity.Aircraft;
import com.axonactive.homeSpringBoot.entity.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CertificateRepository extends JpaRepository<Certificate, Integer> {
    //11.	Cho biết mã số của các loại máy bay mà nhân viên có họ Nguyễn có thể lái.
    @Query(value ="SELECT c.aircraft FROM Certificate AS c JOIN EMPLOYEE AS e WHERE c.employee=e.empID AND e.name Like :name%",nativeQuery = true)
    List<Aircraft> findByEmployeeName(@Param("name") String name);

//    //12.	Cho biết mã số của các phi công vừa lái được Boeing vừa lái được Airbus.
//    @Query(value="SELECT c.employee FROM Certificate AS WHERE c.aircraft IN (SELECT Serial FROM Aircraft WHERE type Like '%Boeing') ")
//    List<>
}
