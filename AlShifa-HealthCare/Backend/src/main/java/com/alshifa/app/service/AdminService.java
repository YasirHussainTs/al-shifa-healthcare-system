package com.alshifa.app.service;

import com.alshifa.app.dto.AdminDto;

import java.util.List;

public interface AdminService {

    AdminDto createAdmin(AdminDto adminDto);

    AdminDto getAdminById(Long adminDto);

    List<AdminDto> getAllAdmins();

    AdminDto updateAdmin(AdminDto adminDto, Long id);

    void deleteAdmin(Long id);
}
