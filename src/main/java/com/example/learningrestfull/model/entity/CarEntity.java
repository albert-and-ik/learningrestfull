package com.example.learningrestfull.model.entity;

import com.example.learningrestfull.model.CarStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name="car")
@Where(clause = "deleted_at is null")
@Getter
@Setter
public class CarEntity extends BaseEntity {

    @Column(nullable = false)
    String model;

    @Column(nullable = false)
    String govNumber;

    @Column(nullable = false)
    int mileage;

    @Column(nullable = false)
    String vin;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    CarStatus status = CarStatus.CREATED;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "owner")
    @JsonIgnore
    DriverEntity owner;
}

