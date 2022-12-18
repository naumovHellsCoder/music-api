package com.naumov.userservice.mapper;

import com.naumov.userservice.dto.UserDto;
import com.naumov.userservice.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper{
    @Override
    public User userFromUserDto(UserDto userDto) {
       User user = new User();
       user.setUsername(userDto.getUsername());
       user.setEmail(userDto.getEmail());
       user.setPassword(userDto.getPassword());
       return user;
    }
}
