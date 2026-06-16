package com.appointments.backend.controller;

import com.appointments.backend.service.BusinessService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/businesses")
@RequiredArgsConstructor
public class BusinessController {
    private final BusinessService businessService;
}
