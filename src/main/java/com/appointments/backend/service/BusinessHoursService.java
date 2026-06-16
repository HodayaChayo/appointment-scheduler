package com.appointments.backend.service;

import com.appointments.backend.repository.BusinessHoursRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BusinessHoursService {
    private final BusinessHoursRepository businessHoursRepository;
}
