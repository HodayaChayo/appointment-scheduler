package com.appointments.backend.model;

import com.appointments.backend.enums.Day;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Entity
@Table(name = "business_hours")
public class BusinessHours {

    @ManyToOne
    @JoinColumn(name = "business_id")
    private Business business;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Day day;

    @Setter
    @Column(nullable = false)
    private LocalTime open;

    @Setter
    @Column(nullable = false)
    private LocalTime close;
}
