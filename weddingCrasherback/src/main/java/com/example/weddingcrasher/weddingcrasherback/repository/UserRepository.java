package com.example.weddingcrasher.weddingcrasherback.repository;



import com.example.weddingcrasher.weddingcrasherback.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    // to register
    boolean existsByEmailAddress(String userEmailAddress);

    //to login
    User findUserByEmailAddress(String email);

//    User findByIdAndUserId(Long Id, Long userId);
}
