package com.bookExchange.UserService.Controllers;

import com.bookExchange.UserService.DTOs.UserDTO;
import com.bookExchange.UserService.Models.GenericResponse;
import com.bookExchange.UserService.Models.User;
import com.bookExchange.UserService.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/")
    public ResponseEntity<GenericResponse> createUser(@RequestBody UserDTO userDTO) {
        userService.createUser(userDTO);
        GenericResponse response = new GenericResponse();
        response.setStatus("Success");
        response.setMessage("User created successfully.");
        return ResponseEntity.ok(response);
    }


    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }


    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }


    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        userService.updateUser(id, userDTO);
        GenericResponse response = new GenericResponse();
        response.setStatus("Success");
        response.setMessage("User updated successfully.");
        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<GenericResponse> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        GenericResponse response = new GenericResponse();
        response.setStatus("Success");
        response.setMessage("User deleted successfully.");
        return ResponseEntity.ok(response);
    }
}
