package com.example.learningrestfull.model.entity;


import com.example.learningrestfull.model.DrivingLicenseCategory;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name="driver")
@Getter
@Setter
public class DriverEntity {

    @Id
    @Column(name = "uuid", updatable = false, nullable = false)
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "UUID")
    public UUID uuid;

    @Column(name = "name", nullable = false)
    @NotNull
    @NotBlank
    public String name;

    @Column(name = "age", nullable = false)
    @NotNull
    @Min(16)
    public int age;

    @Column(name = "creating", nullable = false)
    @NotNull
    public OffsetDateTime creating = OffsetDateTime.now();

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name="driver_lic", nullable = false)
    public DrivingLicenseCategory driverLicenseCategory;

}
