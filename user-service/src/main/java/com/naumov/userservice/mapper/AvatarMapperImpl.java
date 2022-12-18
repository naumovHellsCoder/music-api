package com.naumov.userservice.mapper;

import com.naumov.userservice.entity.Avatar;
import com.naumov.userservice.entity.User;
import com.naumov.userservice.util.FileUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
@AllArgsConstructor
@PropertySource(value = "classpath:/file.properties")
public class AvatarMapperImpl implements AvatarMapper{
    @Value(value = "{file.path}")
    private final String filePath;

    private final FileUtil fileUtil;

    @Override
    public Avatar avatarFromFile(MultipartFile file, User user) {
        String uniqueFileName = fileUtil.generateUniqueImageName();
        String fullPath = filePath + uniqueFileName;
        String originalFileName = file.getOriginalFilename();
        Avatar avatar = new Avatar();
        avatar.setFullPath(fullPath);
        avatar.setUniqueFileName(uniqueFileName);
        avatar.setUser(user);
        avatar.setOriginalFileName(originalFileName);
        return avatar;
    }
}
