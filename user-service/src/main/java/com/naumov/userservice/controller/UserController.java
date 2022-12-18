package com.naumov.userservice.controller;

import com.naumov.userservice.dto.UserDto;
import com.naumov.userservice.entity.User;
import com.naumov.userservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(path = "/api/users/")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(path = "/create",
    consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
    produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createUser(UserDto userDto, MultipartFile file) {
      try{
          User user = userService.createUser(userDto, file);
          return ResponseEntity.ok(user);
      }catch (IOException e){
          e.printStackTrace();
      }
        return null;
    }
}
