package com.example.weddingcrasher.weddingcrasherback.Controller;


import com.example.weddingcrasher.weddingcrasherback.model.Request.LoginRequest;
import com.example.weddingcrasher.weddingcrasherback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Base64;

@RestController
@RequestMapping(path = "/auth/users")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class UserController {

    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void setUserService(UserService userService){this.userService = userService;}

    @CrossOrigin(origins = "*")
    @PostMapping("/login/")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest){ //returns login to user
        return userService.loginUser(loginRequest);
    }



    @GetMapping(path = "/user")
    public Principal user(HttpServletRequest request) {
        String authToken = request.getHeader("Authorization")
                .substring("Basic".length()).trim();
        return () ->  new String(Base64.getDecoder()
                .decode(authToken)).split(":")[0];
    }
//    @PostMapping(path = "/user/{userId}/profile/")
//    public UserProfile createProfile(@PathVariable(value = "userId")Long userId, @RequestBody UserProfile userProfileObject){
//        return userService.createProfile(userId, userProfileObject);
//    }






}
