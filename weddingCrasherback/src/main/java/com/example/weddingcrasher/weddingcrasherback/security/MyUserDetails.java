package com.example.weddingcrasher.weddingcrasherback.security;

import com.example.weddingcrasher.weddingcrasherback.model.WeddingGuest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;

public class MyUserDetails implements UserDetails {

    private WeddingGuest weddingGuest;
    private String emailAddress;
    private String password;

    public MyUserDetails(WeddingGuest weddingGuest) {
        this.weddingGuest = weddingGuest;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new HashSet<GrantedAuthority>();
    }



    @Override
    public String getUsername() {
        return weddingGuest.getEmailAddress();
    }
    @Override
    public String getPassword() {
        return weddingGuest.getLastName();
    }



    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public WeddingGuest getWeddingGuest() {
        return weddingGuest;
    }




}
