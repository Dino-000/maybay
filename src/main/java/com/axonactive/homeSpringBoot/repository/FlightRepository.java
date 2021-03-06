package com.axonactive.homeSpringBoot.repository;

import com.axonactive.homeSpringBoot.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalTime;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight,String > {
    //Cho biết các chuyến bay đi Đà Lạt (DAD).
    List<Flight> findByArrivalTerminal(String arrivalTerminal);

    //Cho biết các chuyến bay có độ dài đường bay nhỏ hơn 10.000km và lớn hơn 8.000km.
    List<Flight> findByDistanceBetween(Integer minDistance, Integer maxDistance);

    //Cho biết các chuyến bay xuất phát từ Sài Gòn (SGN) đi Ban Mê Thuộc (BMV).
    List<Flight> findByArrivalTerminalAndDepartureTerminal(String arrivalTerminal,String departureTerminal);

    //Có bao nhiêu chuyến bay xuất phát từ Sài Gòn (SGN).
//    @Query(value ="SELECT COUNT(f.id) FROM Flight AS f WHERE f.departureTerminal='SaiGon' ")

    List<Flight> findByDistanceLessThan(Integer distance);

    Integer countByDepartureTerminal(String departureTerminal);
    List<Flight> findByDepartureTimeBefore(LocalTime time);

    @Query(value="select f\n" +
            "from Flight f\n" +
            "where distance < (select min(distance)\n" +
            "\t\t\t from Aircraft\n" +
            "\t\t\t where type like 'Boeing%')")
    List<Flight> findByAllBoeingCanExecute();
}
