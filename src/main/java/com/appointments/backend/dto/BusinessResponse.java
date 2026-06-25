package com.appointments.backend.dto;

import lombok.Data;

@Data
public class BusinessResponse {
    private Long id;
    private String name;
    private String phone;
    private String address;
}
