package com.naumov.musicservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/music")
public class MusicController {

    @GetMapping(path = "/")
    @ResponseStatus(HttpStatus.OK)
    public String test(){

        return "test is authenticated";
    }

}
