package com.alshifa.app.service;

import com.alshifa.app.dto.LoginDto;
import com.alshifa.app.dto.RegisterDto;

public interface AuthService {
    String register(RegisterDto registerDto);
    String login(LoginDto loginDto);
}
