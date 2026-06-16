package com.appointments.backend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Entity
@Table(name = "services")
public class Service {

    @ManyToOne
    @JoinColumn(name = "business_id")
    private Business business;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(nullable = false)
    private String name;

    @Setter
    @Column(nullable = false)
    private int timeInMinutes;

    @Setter
    private BigDecimal price;
}
