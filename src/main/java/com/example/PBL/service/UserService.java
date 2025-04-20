package com.example.PBL.service;

import com.example.PBL.model.User;
import com.example.PBL.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Tìm người dùng theo tên (có thể tìm kiếm theo phần tên)
    public List<User> findByNameContaining(String name) {
        return userRepository.findByNameContaining(name);
    }

    // Tìm người dùng theo ID
    public Optional<User> findByIdUser(String id) {
        return Optional.ofNullable(userRepository.findByIdUser(id));
    }

    // Tìm tất cả người dùng
    public List<User> findAll() {
        return userRepository.findAll();
    }

    // Tìm người dùng theo tên hoặc userID
    public Page<User> findByNameContainingIgnoreCaseOrUserIDContaining(String name, String userID, Pageable pageable) {
        return userRepository.findByNameContainingIgnoreCaseOrUserIDContaining(name, userID, pageable);
    }

    // Xóa người dùng theo ID
    public void deleteById(String id) {
        userRepository.deleteById(id);
    }

    // Tìm tất cả người dùng có trạng thái "active"
    public List<User> findByIsActive(Boolean isActive) {
        return userRepository.findByIsActive(isActive);
    }

    // Cập nhật thông tin người dùng
    public User save(User user) {
        return userRepository.save(user);
    }

    // Tìm người dùng theo ngày sinh
    public List<User> findByDateOfBirthBetween(String startDate, String endDate) {
        return userRepository.findByDateOfBirthBetween(startDate, endDate);
    }
}
