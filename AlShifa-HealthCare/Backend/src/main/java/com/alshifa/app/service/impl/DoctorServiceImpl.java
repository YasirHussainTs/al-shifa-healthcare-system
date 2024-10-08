package com.alshifa.app.service.impl;

import com.alshifa.app.dto.DoctorDto;
import com.alshifa.app.dto.UserDto;
import com.alshifa.app.entity.Doctor;
import com.alshifa.app.entity.User;
import com.alshifa.app.repository.DoctorRepository;
import com.alshifa.app.service.DoctorService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        Doctor doctor = doctorRepository.findById(doctorId).
                orElseThrow(() -> new RuntimeException("Doctor not found!"));
        return doctorMapper.map(doctor, DoctorDto.class);
    }

    @Override
    public List<DoctorDto> getAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        return doctors.stream().map((doctor) -> doctorMapper.map(doctor, DoctorDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public DoctorDto updateDoctor(DoctorDto doctorDto, Long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Could not find Doctor"));
        doctor.setFirstName(doctorDto.getFirstName());
        doctor.setSecondName(doctorDto.getSecondName());
        doctor.setEmail(doctorDto.getEmail());
        doctor.setSpecialization(doctorDto.getSpecialization());
        doctor.setExperience(doctorDto.getExperience());
        doctor.setContactInfo(doctorDto.getContactInfo());

        Doctor updatedDoctor = doctorRepository.save(doctor);

        return doctorMapper.map(updatedDoctor, DoctorDto.class);
    }

    @Override
    public void deleteDoctorById(Long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId).
                orElseThrow(() -> new RuntimeException("Could not find Doctor"));
        doctorRepository.deleteById(doctorId);
    }
}
