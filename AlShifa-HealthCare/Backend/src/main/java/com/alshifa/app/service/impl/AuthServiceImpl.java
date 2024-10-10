package com.alshifa.app.service.impl;

import com.alshifa.app.dto.LoginDto;
import com.alshifa.app.dto.RegisterDto;
import com.alshifa.app.entity.Role;
import com.alshifa.app.entity.User;
import com.alshifa.app.repository.RoleRepository;
import com.alshifa.app.repository.UserRepository;
import com.alshifa.app.security.JwtTokenProvider;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Service
public class AuthServiceImpl {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private JwtTokenProvider jwtTokenProvider;

    public String register(RegisterDto registerDto) {

        // Check username is already exists in DB
        if(userRepository.existsByUsername(registerDto.getUsername())) {
            throw new Exception(HttpStatus.BAD_REQUEST, "Username already exists");
        }

        User user = new User();
        user.setFirstName(registerDto.getName());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        Set<Role> roles = new HashSet<Role>();
        Role userRole = roleRepository.findByName("ROLE_USER");
        roles.add(userRole);

        user.setRoles(roles);

        userRepository.save(user);

        return "User Registered Successfully!";
    }

    public String login(LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(new
                        UsernamePasswordAuthenticationToken(
                                loginDto.getUserNameOrEmail(),
                                loginDto.getPassword()
                        ));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenProvider.generateToken(authentication);

        return token;
    }
}