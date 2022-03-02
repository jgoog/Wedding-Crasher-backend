package com.example.weddingcrasher.weddingcrasherback.Controller;

import com.example.weddingcrasher.weddingcrasherback.model.User;
import com.example.weddingcrasher.weddingcrasherback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.image.BufferedImage;
import java.util.List;


@RequestMapping(path = "/api")
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
public class QRCCodeController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService){this.userService = userService;}

    @CrossOrigin(origins = "*")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/allusers/")
    public String testWorld(){
        return "Welcome to my world";
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/test-world/")
    public ResponseEntity<List<User>> getALlUsers() {
        List<User> users= userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

}
