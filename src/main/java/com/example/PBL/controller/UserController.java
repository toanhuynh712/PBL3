package com.example.PBL.controller;

import com.example.PBL.model.User;
import com.example.PBL.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/search")
    public Page<User> searchUsers(@RequestParam Optional<String> name, 
                                  @RequestParam Optional<String> userID,
                                  @RequestParam(defaultValue = "0") int page, 
                                  @RequestParam(defaultValue = "10") int size) {
        
        PageRequest pageRequest = PageRequest.of(page, size);
        
        // Nếu không có gì được nhập vào thì trả về tất cả tài khoản
        if (name.isEmpty() && userID.isEmpty()) {
            return userRepository.findAll(pageRequest);
        } else {
            return userRepository.findByNameContainingIgnoreCaseOrUserIDContaining(name.orElse(""), 
                                                                                   userID.orElse(""), 
                                                                                   pageRequest);
        }
    }
}
