package com.example.weddingcrasher.weddingcrasherback.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.image.BufferedImage;


@RequestMapping(path = "/api")
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
public class QRCCodeController {

    @CrossOrigin(origins = "*")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/test-world/")
    public String testWorld(){
        return "Welcome to my world";
    }

}
