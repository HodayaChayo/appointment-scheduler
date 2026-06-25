package com.appointments.backend.dto;
import com.appointments.backend.model.BusinessHours;
import com.appointments.backend.model.Service;
import lombok.Data;
import java.util.List;

@Data
public class BusinessDetailResponse {
    private Long id;
    private String name;
    private String phone;
    private String address;
    private List<BusinessHoursResponse> businessHours;
    private List<ServiceResponse> services;
}
