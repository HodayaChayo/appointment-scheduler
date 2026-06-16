package com.appointments.backend.model;

import com.appointments.backend.enums.AppointmentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Entity
@Table(name = "appointments")
public class Appointment {

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "business_id")
    private Business business;

    @ManyToMany
    @JoinTable(name = "appointment_services",
            joinColumns = @JoinColumn(name = "appointment_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id"))
    private List<Service> services;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(nullable = false)
    private LocalDate date;

    @Setter
    @Column(nullable = false)
    private LocalTime start;

    @Setter
    @Column(nullable = false)
    private LocalTime end;

    @Setter
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AppointmentStatus appointmentStatus;
}
