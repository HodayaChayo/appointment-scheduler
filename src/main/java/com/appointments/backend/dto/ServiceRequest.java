package com.appointments.backend.dto;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class ServiceRequest {
    private String name;
    private int timeInMinutes;
    private BigDecimal price;
}
