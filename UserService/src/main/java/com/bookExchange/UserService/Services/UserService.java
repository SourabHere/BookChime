package com.bookExchange.UserService.Services;

import com.bookExchange.UserService.DTOs.UserDTO;
import com.bookExchange.UserService.Models.User;
import com.bookExchange.UserService.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public void createUser(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        userRepository.save(user);
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new RuntimeException("User not found"));
    }


    public void updateUser(Long id, UserDTO userDTO) {
        User user = getUserById(id);
        user.setUsername(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        userRepository.save(user);
    }


    public void deleteUser(Long id) {
        User user = getUserById(id);
        userRepository.delete(user);
    }
}
