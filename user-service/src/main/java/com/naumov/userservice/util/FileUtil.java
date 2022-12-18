package com.naumov.userservice.util;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class FileUtil {
    public String generateUniqueImageName(){
        return UUID.randomUUID().toString() + ".jpg";
    }
}
