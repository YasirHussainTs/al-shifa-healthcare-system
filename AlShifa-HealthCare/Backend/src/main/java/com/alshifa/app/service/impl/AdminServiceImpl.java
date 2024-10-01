package com.alshifa.app.service.impl;

import com.alshifa.app.dto.AdminDto;
import com.alshifa.app.entity.Admin;
import com.alshifa.app.repository.AdminRepository;
import com.alshifa.app.service.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    private AdminRepository adminRepository;
    private ModelMapper adminMapper;

    @Override
    public AdminDto createAdmin(AdminDto adminDto) {
        Admin admin = adminMapper.map(adminDto, Admin.class);

        Admin savedAdmin = adminRepository.save(admin);

        AdminDto savedAdminDto = adminMapper.map(savedAdmin, AdminDto.class);

        return savedAdminDto;
    }

    @Override
    public AdminDto getAdminById(Long adminId) {
        Admin admin = adminRepository.findById(adminId)
                .orElseThrow(() -> new RuntimeException("Not found with Id! " + adminId));
        return adminMapper.map(admin, AdminDto.class);
    }

    @Override
    public List<AdminDto> getAllAdmins() {
        return List.of();
    }

    @Override
    public AdminDto updateAdmin(AdminDto adminDto, Long id) {
        return null;
    }

    @Override
    public void deleteAdmin(Long id) {

    }
}
