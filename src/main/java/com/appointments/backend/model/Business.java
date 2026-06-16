package com.appointments.backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Entity
@Table(name = "business")
public class Business {

    @OneToMany(mappedBy = "business")
    private List<BusinessHours> businessHours;

    @OneToMany(mappedBy = "business")
    private List<Service> services;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(nullable = false)
    private String name;

    @Setter
    @Column(length = 10, nullable = false)
    private String phone;

    @Setter
    private String address;
}
