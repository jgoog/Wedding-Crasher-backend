package com.example.weddingcrasher.weddingcrasherback.Controller;

import com.example.weddingcrasher.weddingcrasherback.model.Request.LoginRequest;
import com.example.weddingcrasher.weddingcrasherback.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/auth/users")
public class GuestController {

    private GuestService guestService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void setGuestService (GuestService guestService){this.guestService =guestService;}

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest){ //returns login to user
        return guestService.loginUser(loginRequest);
    }


}
