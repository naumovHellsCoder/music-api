package com.naumov.userservice.mapper;

import com.naumov.userservice.entity.Avatar;
import com.naumov.userservice.entity.User;
import org.springframework.web.multipart.MultipartFile;

public interface AvatarMapper {
    Avatar avatarFromFile(MultipartFile file, User user);
}
