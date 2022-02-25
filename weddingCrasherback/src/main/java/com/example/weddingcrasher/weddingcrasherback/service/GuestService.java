package com.example.weddingcrasher.weddingcrasherback.service;
import com.example.weddingcrasher.weddingcrasherback.model.Request.LoginRequest;
import com.example.weddingcrasher.weddingcrasherback.model.WeddingGuest;
import com.example.weddingcrasher.weddingcrasherback.respository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class GuestService {

    @Autowired
    public void setGuestRepository(GuestRepository guestRepository){this.guestRepository =guestRepository;}

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    public ResponseEntity<?> loginUser(LoginRequest loginRequest){
        authenticationManager.authenticate(new )
    }


    public WeddingGuest findUserByEmailAddress(String email) {return GuestRepository.findUserByEmailAddress(email);}

}
