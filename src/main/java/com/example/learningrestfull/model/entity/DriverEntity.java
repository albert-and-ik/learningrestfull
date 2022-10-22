package com.example.learningrestfull.model.entity;


import com.example.learningrestfull.model.DrivingCategory;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="driver")
@Where(clause = "deleted_at is null")
@Getter
@Setter
public class DriverEntity extends BaseEntity{

    @NotBlank
    @Column(nullable = false)
    String name;

    @Min(18)
    @Column(nullable = false)
    int age;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    DrivingCategory driverCategory;
}
