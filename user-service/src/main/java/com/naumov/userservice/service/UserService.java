package com.naumov.userservice.service;

import com.naumov.userservice.dto.UserDto;
import com.naumov.userservice.entity.Avatar;
import com.naumov.userservice.entity.User;
import com.naumov.userservice.mapper.AvatarMapperImpl;
import com.naumov.userservice.mapper.UserMapperImpl;
import com.naumov.userservice.repository.AvatarRepository;
import com.naumov.userservice.repository.UserRepository;
import com.naumov.userservice.util.FileUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final AvatarRepository avatarRepository;
    private final AvatarMapperImpl avatarMapper;
    private final UserMapperImpl userMapper;
    private final FileUtil fileUtil;

    public User createUser(UserDto userDto, MultipartFile file)throws IOException {
        User user = userMapper.userFromUserDto(userDto);
        Avatar avatar = avatarMapper.avatarFromFile(file, user);
        user.setAvatar(avatar);
        fileUtil.uploadImage(file.getBytes(), avatar.getFullPath());
        avatarRepository.save(avatar);
        User userSave =  userRepository.save(user);
        return userSave;
    }
}
