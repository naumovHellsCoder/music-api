package com.naumov.userservice.controller;

import com.naumov.userservice.dto.UserDto;
import com.naumov.userservice.entity.User;
import com.naumov.userservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users/")
@AllArgsConstructor
public class UserController {
    private UserService userService;
    @PostMapping(path = "/create",
            produces = {MediaType.APPLICATION_JSON_VALUE},
    consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createUser(
            @Validated @RequestBody(required = true)UserDto userDto){
        User user = userService.createUser(userDto);
        return ResponseEntity.ok(user);
    }
}
