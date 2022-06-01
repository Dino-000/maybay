package com.axonactive.homeSpringBoot.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Employee {
    @NotNull
    @Id
    @Size(max = 9)
    private String id;

    @NotNull
    @Size(max = 50)
    private String name;

    @NotNull
    private Integer salary;
}
