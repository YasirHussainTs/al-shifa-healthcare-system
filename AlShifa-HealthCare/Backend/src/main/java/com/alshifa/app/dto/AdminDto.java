package com.alshifa.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AdminDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Set<String> roles;
}
