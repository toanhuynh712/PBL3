package com.example.PBL.repository;

import com.example.PBL.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;


import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    
    // Tìm tài khoản theo username
    Account findByUsername(String username);  

    // Tìm tài khoản theo email
    Optional<Account> findByEmail(String email);
    
    // Tìm tất cả tài khoản theo role (USER hoặc ADMIN)
    List<Account> findByRole(Account.Role role);

    // Tìm tài khoản theo trạng thái (ACTIVE hoặc LOCKED)
    List<Account> findByStatus(Account.Status status);
    
    // Tìm tài khoản theo trạng thái và role
    List<Account> findByStatusAndRole(Account.Status status, Account.Role role);
    
    // Tìm tài khoản theo tên (dùng khi tìm kiếm user)
    List<Account> findByUsernameContaining(String username);
    
    // Kiểm tra tồn tại tài khoản theo username
    boolean existsByUsername(String username);
    
    // Kiểm tra tồn tại tài khoản theo email
    boolean existsByEmail(String email);

    // Khóa tài khoản (cập nhật trạng thái tài khoản thành LOCKED)
    @Modifying
    @Query("UPDATE Account a SET a.status = :status WHERE a.accountID = :accountID")
    void updateStatus(@Param("accountID") Long accountID, @Param("status") Account.Status status);
}
