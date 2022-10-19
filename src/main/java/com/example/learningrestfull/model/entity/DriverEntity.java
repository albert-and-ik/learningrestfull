package com.example.learningrestfull.model.entity;


import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.UUID;
import com.example.learningrestfull.model.DrivingLicenseCategory;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="driver")
@Getter
@Setter
public class DriverEntity {
    @Id
    @Column(name = "uuid")
    public UUID uuid;

    @Column(name = "name")
    public String name;

    @Column(name = "age")
    public int age;

    @Column(name = "creating")
    public OffsetDateTime creating;

    @Enumerated(EnumType.STRING)
    @Column(name="driver_lic")
    public DrivingLicenseCategory driverLicenseCategory;

}
