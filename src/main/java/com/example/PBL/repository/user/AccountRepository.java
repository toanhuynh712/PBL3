package com.example.PBL.repository.user;

import com.example.PBL.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    // Tìm tài khoản theo username
    Account findByUsername(String username);

    // Tìm tài khoản theo email
    Optional<Account> findByEmail(String email);

    // Kiểm tra tồn tại tài khoản theo username
    boolean existsByUsername(String username);

    // Kiểm tra tồn tại tài khoản theo email
    boolean existsByEmail(String email);

    // Tìm tất cả tài khoản theo vai trò (USER hoặc ADMIN)
    List<Account> findByRole(Account.Role role);

    // Tìm tất cả tài khoản theo trạng thái (ACTIVE hoặc LOCKED)
    List<Account> findByStatus(Account.Status status);

    // Tìm tài khoản theo cả trạng thái và vai trò
    List<Account> findByStatusAndRole(Account.Status status, Account.Role role);

    // Tìm tài khoản theo username gần đúng (không phân biệt hoa thường)
    List<Account> findByUsernameContainingIgnoreCase(String username);

    // Cập nhật trạng thái tài khoản (VD: khóa tài khoản)
    void updateStatusByAccountID(Long accountID, Account.Status status);

    // Phân trang theo role (ADMIN, USER)
    Page<Account> findByRole(Account.Role role, Pageable pageable);

    // Phân trang theo status (ACTIVE, LOCKED)
    Page<Account> findByStatus(Account.Status status, Pageable pageable);

    // Phân trang kết hợp role + status
    Page<Account> findByStatusAndRole(Account.Status status, Account.Role role, Pageable pageable);

    // Tìm kiếm theo username (có phân trang)
    Page<Account> findByUsernameContainingIgnoreCase(String username, Pageable pageable);
}
