package com.example.weddingcrasher.weddingcrasherback.respository;

import com.example.weddingcrasher.weddingcrasherback.model.GuestList;
import com.example.weddingcrasher.weddingcrasherback.model.WeddingGuest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<GuestList, Long> {

    // to register
//    boolean existsByEmailAddress(String userEmailAddress);


    //to login
    GuestList findByLastName(String lastName);
}
