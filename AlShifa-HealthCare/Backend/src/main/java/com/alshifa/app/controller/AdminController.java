package com.alshifa.app.controller;

import com.alshifa.app.dto.AdminDto;
import com.alshifa.app.service.AdminService;
import lombok.AllArgsConstructor;
import org.modelmapper.internal.bytebuddy.asm.Advice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/alshifa/adminpanel")
public class AdminController {

    private AdminService adminService;

    @PostMapping
    public ResponseEntity<AdminDto> createAdmin(@RequestBody AdminDto admin){
        AdminDto savedAdmin = adminService.createAdmin(admin);
        return new ResponseEntity<>(savedAdmin, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdminDto> getAdminById(@PathVariable("id") Long adminId){
        AdminDto savedAdmin = adminService.getAdminById(adminId);
        return new ResponseEntity<>(savedAdmin, HttpStatus.OK);
    }

}
