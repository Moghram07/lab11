package com.example.lab11blog.Repository;

import com.example.lab11blog.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUserNameAndPassword(String userName, String password);

    User findByEmail(String email);

    User findUserById(Integer id);

    List<User> findUserByRegistrationDateAfter(Date date);

}
