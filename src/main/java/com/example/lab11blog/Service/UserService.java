package com.example.lab11blog.Service;

import com.example.lab11blog.ApiException.ApiException;
import com.example.lab11blog.Model.User;
import com.example.lab11blog.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(Integer id, User user) {
        User u = userRepository.findUserById(id);
        if (u == null) {
            throw new ApiException("User not found");
        }
        u.setUserName(user.getUserName());
        u.setEmail(user.getEmail());
        u.setPassword(user.getPassword());

        userRepository.save(u);
    }

    public void deleteUser(Integer id) {
        User u = userRepository.findUserById(id);
        if (u == null) {
            throw new ApiException("User not found");
        }
        userRepository.delete(u);
    }

    public User findByUsernameAndPassword(String username, String password) {
        User u = userRepository.findByUserNameAndPassword(username, password);
        if (u == null) {
            throw new ApiException("User not found");
        }
        return u;
    }

    public User findUserByEmail(String email) {
        User u = userRepository.findByEmail(email);
        if (u == null) {
            throw new ApiException("User not found");
        }
        return u;
    }

    public List<User> findByDateAfter(Date date) {
        List <User> u = userRepository.findUserByRegistrationDateAfter(date);
        if (u.isEmpty()) {
            throw new ApiException("User not found");
        }
        return u;
    }
}
