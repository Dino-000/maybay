package com.axonactive.homeSpringBoot.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="flights")
public class Flight {
    @Id
    @Column(length = 5)
    private String id;

    @NotNull
    @Size(max = 50 )
    private String departureTerminal;

    @NotNull
    @Size(max = 50 )
    private String arrivalTerminal;


    @NotNull
    private Integer distance;

    @NotNull
    private LocalTime departureTime;

    @NotNull
    private LocalTime arrivalTime;

    @NotNull
    private double price;

}
