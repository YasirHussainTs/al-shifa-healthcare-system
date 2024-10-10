package com.alshifa.app.controller;

import com.alshifa.app.dto.DoctorDto;
import com.alshifa.app.service.DoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {
    private DoctorService doctorService;

    @PostMapping()
    public ResponseEntity<DoctorDto> createDoctor(@RequestBody DoctorDto doctorDto) {
        DoctorDto doctor = doctorService.createDoctor(doctorDto);
        return new ResponseEntity<>(doctor, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorDto> getByDoctorId(@PathVariable("id") Long userId) {
        DoctorDto doctor = doctorService.getDoctorById(userId);
        return new ResponseEntity<>(doctor, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<DoctorDto>> getAllDoctors() {
        List<DoctorDto> doctors = doctorService.getAllDoctors();
        return ResponseEntity.ok(doctors);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoctorDto> updateDoctor(@RequestBody DoctorDto doctor, @PathVariable("id") Long doctorId) {
        DoctorDto doctorDto = doctorService.updateDoctor(doctor, doctorId);
        return ResponseEntity.ok(doctorDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable("id") Long doctorId){
        doctorService.deleteDoctorById(doctorId);
        return ResponseEntity.ok("Doctor deleted successfully");
    }

}
