package com.alshifa.app.service.impl;

import com.alshifa.app.dto.DoctorDto;
import com.alshifa.app.entity.Doctor;
import com.alshifa.app.repository.DoctorRepository;
import com.alshifa.app.service.DoctorService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {
    private DoctorRepository doctorRepository;
    private ModelMapper doctorMapper;

    @Override
    public DoctorDto createDoctor(DoctorDto doctorDto) {
        Doctor doctor = doctorMapper.map(doctorDto, Doctor.class);
        Doctor savedDoctor = doctorRepository.save(doctor);
        DoctorDto savedDoctorDto = doctorMapper.map(savedDoctor, DoctorDto.class);

        return savedDoctorDto;
    }

    @Override
    public DoctorDto getDoctorById(Long doctorId) {
        return null;
    }

    @Override
    public List<DoctorDto> getAllDoctor() {
        return List.of();
    }

    @Override
    public DoctorDto updateDoctor(DoctorDto doctorDto, Long doctorId) {
        return null;
    }

    @Override
    public void deleteDoctor(Long doctorId) {

    }
}
