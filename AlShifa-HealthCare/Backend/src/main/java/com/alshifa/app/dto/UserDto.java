package com.alshifa.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String firstName;
    private String secondName;
    private String email;
    private Integer age;
    private String gender;
    private String contactInfo;
    private String address;
    private Set<String> roles; // Simplified to role names for easier transfer
    private List<MedicalHistoryDto> medicalHistory; // Nested DTO for medical history
}
