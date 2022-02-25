package com.example.weddingcrasher.weddingcrasherback.respository;

import com.example.weddingcrasher.weddingcrasherback.model.WeddingGuest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<WeddingGuest, Long> {

    // to register
    boolean existsByEmailAddress(String userEmailAddress);


    //to login
    WeddingGuest findUserByEmailAddress(String emailAddress);

}
