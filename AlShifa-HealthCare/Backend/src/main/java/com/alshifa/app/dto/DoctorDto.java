package com.alshifa.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDto {
    private Long id;
    private String firstName;
    private String secondName;
    private String email;
    private String specialization;
    private Integer experience;
    private String contactInfo;
    private Set<String> roles; // Using role names instead of full Role objects
}
