package com.naumov.userservice.mapper;

import com.naumov.userservice.dto.UserDto;
import com.naumov.userservice.entity.User;

public interface UserMapper {
    User userFromUserDto(UserDto userDto);
}
