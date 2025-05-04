package com.toinfinityandbeyong.ERPMS.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("ADMIN")
@Table(name = "administrators")
public class Administrator extends User
{
    @Column(nullable = false)
    private String department;

    @Column
    private String position;

    @Column
    private String adminLevel;
}
