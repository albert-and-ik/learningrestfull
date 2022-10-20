package com.example.learningrestfull.model.entity;

import com.example.learningrestfull.model.StatusCar;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name="car")
@Getter
@Setter
public class CarEntity {

    @Id
    @Column(name = "uuid", updatable = false, nullable = false)
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "UUID")
    public UUID uuid;

    @Column(name = "model")
    public String model;

    @Column(name="gov_number")
    public String govNumber;

    @Column(name = "mileage")
    public int mileage;

    @Column(name="vin")
    public String vin;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    public StatusCar status = StatusCar.CREATED;

    @Column(name = "creating")
    public OffsetDateTime creating = OffsetDateTime.now();

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "owner")
    @JsonIgnore
    public DriverEntity owner;
}

