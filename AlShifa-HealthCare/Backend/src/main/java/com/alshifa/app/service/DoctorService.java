package com.alshifa.app.service;

import com.alshifa.app.dto.DoctorDto;

import java.util.List;

public interface DoctorService {
    DoctorDto createDoctor(DoctorDto doctorDto);

    DoctorDto getDoctorById(Long doctorId);

    List<DoctorDto> getAllDoctor();

    DoctorDto updateDoctor(DoctorDto doctorDto,Long doctorId);

    void deleteDoctor(Long doctorId);
}
