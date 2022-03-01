package com.example.weddingcrasher.weddingcrasherback.service;


import com.example.weddingcrasher.weddingcrasherback.model.Request.LoginRequest;
import com.example.weddingcrasher.weddingcrasherback.model.Response.LoginResponse;
import com.example.weddingcrasher.weddingcrasherback.model.User;
import com.example.weddingcrasher.weddingcrasherback.repository.UserRepository;
import com.example.weddingcrasher.weddingcrasherback.security.JWTUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;




    @Autowired
    public void setUserRepository(UserRepository userRepository) {this.userRepository = userRepository;}

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JWTUtils jwtUtils;



    public ResponseEntity<?> loginUser(LoginRequest loginRequest){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),loginRequest.getPassword()));

        final UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getEmail());

        final String JWT = jwtUtils.generateToken(userDetails);

        return ResponseEntity.ok((new LoginResponse(JWT)));
    }

//    public UserProfile createProfile(Long userId, UserProfile userObject){
//        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        User user = userRepository.findByIdAndUserId(userId,userDetails.getUser().getId());
//        if (user == null) {
//            throw new InformationNotFoundException(
//                    "user with id " + userId + " does not belongs to this user or user oes not exist");
//        }
////        UserProfile userProfile = userProfileRepository.findByLastNameAndUserId(userObject.getLastName(), userDetails.getUser().getId());
////        if (userProfile != null) {
////            throw new InformationExistException("profile with name " + userProfile.getLastName() + " already exists");
////        }
////        userObject.setUser(userDetails.getUser());
////        userObject.setUser(user);
//        return userProfileRepository.save(userObject);
//    }




    public User findUserByEmailAddress(String email) {
        return userRepository.findUserByEmailAddress(email);
    }
}
