package com.example.PBL.controller;

import com.example.PBL.model.User;
import com.example.PBL.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Tìm người dùng theo tên (có thể tìm kiếm theo phần tên)
    @GetMapping("/search")
    public ResponseEntity<List<User>> searchUsers(@RequestParam String name) {
        List<User> users = userService.findByNameContaining(name);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // Tìm người dùng theo ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        Optional<User> user = userService.findByIdUser(id);
        return user.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Lấy tất cả người dùng
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // Tìm người dùng theo tên hoặc userID
    @GetMapping("/search-advanced")
    public ResponseEntity<Page<User>> searchUsersAdvanced(@RequestParam(required = false) String name,
                                                           @RequestParam(required = false) String userID,
                                                           Pageable pageable) {
        Page<User> users = userService.findByNameContainingIgnoreCaseOrUserIDContaining(name, userID, pageable);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // Xóa người dùng theo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Lấy tất cả người dùng có trạng thái "active"
    @GetMapping("/active")
    public ResponseEntity<List<User>> getActiveUsers() {
        List<User> activeUsers = userService.findByIsActive(true);
        return new ResponseEntity<>(activeUsers, HttpStatus.OK);
    }

    // Cập nhật thông tin người dùng
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User user) {
        Optional<User> existingUser = userService.findByIdUser(id);
        if (existingUser.isPresent()) {
            user.setUserID(id); // Đảm bảo ID của người dùng không thay đổi
            User updatedUser = userService.save(user);
            return ResponseEntity.ok(updatedUser);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Tìm người dùng theo ngày sinh trong khoảng thời gian
    @GetMapping("/dob")
    public ResponseEntity<List<User>> getUsersByDob(@RequestParam String startDate, @RequestParam String endDate) {
        List<User> users = userService.findByDateOfBirthBetween(startDate, endDate);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // Thêm người dùng mới
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User newUser = userService.save(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
}
