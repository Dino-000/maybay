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
public class Aircraft {
    @Id
    @NotNull
    private Integer id;

    @Size(max = 50)
    @NotNull
    private String type;

    @NotNull
    private Integer distance;
}
