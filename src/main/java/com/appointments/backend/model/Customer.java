package com.appointments.backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Entity
@Table(name = "customers")
public class Customer {

    @OneToMany(mappedBy = "customer")
    private List<Appointment> appointments;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(nullable = false)
    private String name;

    @Setter
    @Column(unique = true, nullable = false)
    private String email;

    @Setter
    @Column(length = 10, nullable = false)
    private String phone;
}
