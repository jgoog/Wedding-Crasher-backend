package com.example.weddingcrasher.weddingcrasherback.security;

import com.example.weddingcrasher.weddingcrasherback.model.WeddingGuest;
import com.example.weddingcrasher.weddingcrasherback.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private GuestService guestService;

    @Autowired
    public void setGuestService(GuestService guestService){ this.guestService = guestService;}

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        WeddingGuest guest = guestService.findUserByEmailAddress(email);
        return new MyUserDetails(guest);
    }
}
