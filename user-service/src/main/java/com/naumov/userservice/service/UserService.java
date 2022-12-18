package com.naumov.userservice.service;

import com.naumov.userservice.dto.UserDto;
import com.naumov.userservice.entity.User;
import com.naumov.userservice.mapper.UserMapperImpl;
import com.naumov.userservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapperImpl userMapper;

    public User createUser(UserDto userDto){
        User user = userMapper.userFromUserDto(userDto);
        User userSave  = userRepository.save(user);
        return userSave;
    }
}
