package com.alshifa.app.controller;

import com.alshifa.app.dto.DoctorDto;
import com.alshifa.app.service.DoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {
    private DoctorService doctorService;

    @PostMapping()
    public ResponseEntity<DoctorDto> createDoctor(@RequestBody DoctorDto doctorDto) {
        DoctorDto doctor = doctorService.createDoctor(doctorDto);
        return new ResponseEntity<>(doctor, HttpStatus.CREATED);
    }
}
