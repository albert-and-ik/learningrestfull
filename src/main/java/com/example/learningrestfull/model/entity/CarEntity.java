package com.example.learningrestfull.model.entity;

import com.example.learningrestfull.model.StatusCar;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="car")
@Getter
@Setter
public class CarEntity {

    @Id
    @Column(name = "uuid")
    public UUID uuid;

    @Column(name = "model")
    public String model;

    @Column(name="gov_number")
    public String govNumber;

    @Column(name = "mileage")
    public int mileage;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    public StatusCar status;

    @ManyToOne(optional = false, fetch = FetchType.LAZY, targetEntity = CarEntity.class)
    @JoinColumn(name = "owner")
    public DriverEntity owner;
}

