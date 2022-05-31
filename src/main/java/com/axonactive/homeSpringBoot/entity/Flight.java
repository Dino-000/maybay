package com.axonactive.homeSpringBoot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(length = 5)
    private String id;

    @NotNull
    @Size(max = 50 )
    private String arrivalTerminal;

    @NotNull
    @Size(max = 50 )
    private String departureTerminal;

    @NotNull
    private Integer distance;

    @NotNull
    private Date depatureTime;

    @NotNull
    private Date arrivalTime;

    @NotNull
    private double price;

}
