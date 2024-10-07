package com.alshifa.app.service.impl;

import com.alshifa.app.dto.UserDto;
import com.alshifa.app.entity.User;
import com.alshifa.app.repository.UserRepository;
import com.alshifa.app.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ModelMapper userMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = userMapper.map(userDto, User.class);

        User savedUser = userRepository.save(user);

        UserDto savedUserDto = userMapper.map(savedUser, UserDto.class);

        return savedUserDto;
    }

    @Override
    public UserDto getUserById(Long userId) {
        return null;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return List.of();
    }

    @Override
    public UserDto updateUser(UserDto user, Long userId) {
        return null;
    }

    @Override
    public void deleteUser(Long userId) {

    }
}
