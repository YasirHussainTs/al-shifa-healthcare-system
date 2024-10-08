package com.alshifa.app.service.impl;

import com.alshifa.app.dto.UserDto;
import com.alshifa.app.entity.User;
import com.alshifa.app.repository.UserRepository;
import com.alshifa.app.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        User user = userRepository.findById(userId).
                orElseThrow(() -> new RuntimeException("User not found!"));
        return userMapper.map(user, UserDto.class);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map((user) -> userMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto userDto, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Could not find user"));
        user.setFirstName(userDto.getFirstName());
        user.setSecondName(userDto.getSecondName());
        user.setEmail(userDto.getEmail());
        user.setAge(userDto.getAge());
        user.setGender(userDto.getGender());
        user.setContactInfo(userDto.getContactInfo());
        user.setAddress(userDto.getAddress());

        User updatedUser = userRepository.save(user);

        return userMapper.map(updatedUser, UserDto.class);
    }

    @Override
    public void deleteUserById(Long userId) {
        User user = userRepository.findById(userId).
                orElseThrow(() -> new RuntimeException("Could not find user"));
        userRepository.deleteById(userId);
    }
}
