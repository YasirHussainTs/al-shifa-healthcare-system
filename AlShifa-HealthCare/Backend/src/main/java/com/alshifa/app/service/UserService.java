package com.alshifa.app.service;

import com.alshifa.app.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);

    UserDto getUserById(Long userId);

    List<UserDto> getAllUsers();

    UserDto updateUser(UserDto user, Long userId);

    void deleteUserById(Long userId);
}
