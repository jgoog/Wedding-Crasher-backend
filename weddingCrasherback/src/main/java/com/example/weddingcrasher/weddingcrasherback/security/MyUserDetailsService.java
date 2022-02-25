package com.example.weddingcrasher.weddingcrasherback.security;

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
    public UserDetails loadGuestByLastName(String email) throws UsernameNotFoundException{
        Guest guest = guestService.findGuestByEmailAddress(email);
        return new MyUserDetails(user)
    }


}
