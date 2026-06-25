package com.appointments.backend.dto;
import com.appointments.backend.enums.Day;
import lombok.Data;
import java.time.LocalTime;

@Data
public class BusinessHoursResponse {
    private Long id;
    private Day day;
    private LocalTime open;
    private LocalTime close;
}
