package com.alshifa.app.service;

import com.alshifa.app.dto.DoctorDto;

import java.util.List;

public interface DoctorService {
    DoctorDto createDoctor(DoctorDto doctorDto);

    DoctorDto getDoctorById(Long doctorId);

    List<DoctorDto> getAllDoctors();

    DoctorDto updateDoctor(DoctorDto doctorDto,Long doctorId);

    void deleteDoctorById(Long doctorId);
}
