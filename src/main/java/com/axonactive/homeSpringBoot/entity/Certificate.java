package com.axonactive.homeSpringBoot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "certificates")
public class Certificate {
    @Id
    @NotNull // Do I have to put @NotNull in a field has GeneratedValue?
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "employee_id")
    Employee employee;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "aircraft_id")
    Aircraft aircraft;
}
