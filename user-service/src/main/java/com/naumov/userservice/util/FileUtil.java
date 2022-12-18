package com.naumov.userservice.util;

import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

@Component
public class FileUtil {
    public String generateUniqueImageName(){
        return UUID.randomUUID().toString() + ".jpg";
    }
    public void uploadImage(byte[] bytes, String fullPath){
        try{
            File file = new File(fullPath);
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            for(Byte b:bytes){
                writer.write(b);
            }
            writer.flush();
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
