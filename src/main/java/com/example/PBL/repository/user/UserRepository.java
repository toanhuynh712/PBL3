package com.example.PBL.repository.user;

import com.example.PBL.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    // Tìm người dùng theo tên
    List<User> findByNameContaining(String name);  // Tìm người dùng theo tên (có thể tìm kiếm theo phần tên)

    // Tìm người dùng theo ID (có thể dùng để quản lý tài khoản)
    User findByIdUser(Long id);

    // Tìm tất cả người dùng (để quản lý người dùng trong trường hợp Admin)
    List<User> findAll();

     // Tìm người dùng theo tên (phần tên) hoặc userID (phần ID)
     Page<User> findByNameContainingIgnoreCaseOrUserIDContaining(String name, String userID, Pageable pageable);

    // Xóa người dùng (được thực hiện bởi Admin)
    void deleteById(Long id);

    // Tìm tất cả người dùng có trạng thái "active"
    List<User> findByIsActive(Boolean isActive);  // Trạng thái active hay không (có thể áp dụng cho việc khóa/mở khóa tài khoản)

    // Cập nhật thông tin người dùng bằng ID
    User save(User user);  // Dùng phương thức này để lưu thông tin người dùng sau khi cập nhật

    // Tìm người dùng theo ngày sinh
    List<User> findByDateOfBirthBetween(String startDate, String endDate);  // Tìm theo khoảng thời gian ngày sinh

}
