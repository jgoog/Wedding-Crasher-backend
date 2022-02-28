package com.example.weddingcrasher.weddingcrasherback.service;
import com.example.weddingcrasher.weddingcrasherback.model.GuestList;
import com.example.weddingcrasher.weddingcrasherback.model.Request.LoginRequest;
import com.example.weddingcrasher.weddingcrasherback.model.Response.LoginResponse;
import com.example.weddingcrasher.weddingcrasherback.respository.GuestRepository;
import com.example.weddingcrasher.weddingcrasherback.security.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class GuestService {

    private GuestRepository guestRepository;

    @Autowired
    public void setGuestRepository(GuestRepository guestRepository){this.guestRepository = guestRepository;}

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JWTUtils jwtUtils;

    public ResponseEntity<?> loginUser(LoginRequest loginRequest){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),loginRequest.getLastName()));

        final UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getEmail());


        final String JWT = jwtUtils.generateToken(userDetails);

        return ResponseEntity.ok((new LoginResponse(JWT))) ;
    }


    public GuestList findByLastName(String lastName){return guestRepository.findByLastName(lastName);}

}
