package com.example.PBL.service;

import com.example.PBL.model.Account;
import com.example.PBL.repository.user.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    // Đăng ký tài khoản mới
    public Account registerAccount(Account account) {
        // Kiểm tra xem username hoặc email đã tồn tại hay chưa
        if (accountRepository.existsByUsername(account.getUsername()) || accountRepository.existsByEmail(account.getEmail())) {
            throw new IllegalArgumentException("Username or email already exists");
        }
        return accountRepository.save(account);  // Lưu tài khoản mới
    }

    // Cập nhật trạng thái tài khoản (lock/unlock)
    public void updateAccountStatus(Long accountID, Account.Status status) {
        // Sử dụng phương thức tự động cập nhật trạng thái tài khoản
        accountRepository.findById(accountID).ifPresent(account -> {
            account.setStatus(status);
            accountRepository.save(account); // Lưu lại tài khoản với trạng thái mới
        });
    }

    // Tìm tài khoản theo username
    public Account findByUsername(String username) {
        return accountRepository.findByUsername(username);  // Tìm tài khoản theo username
    }

    // Tìm tài khoản theo email
    public Optional<Account> findByEmail(String email) {
        return accountRepository.findByEmail(email);  // Tìm tài khoản theo email
    }

    // Tìm tài khoản theo trạng thái (ACTIVE/LOCKED)
    public List<Account> findByStatus(Account.Status status) {
        return accountRepository.findByStatus(status);  // Tìm tài khoản theo trạng thái
    }

    // Tìm tài khoản theo tên (phần username)
    public List<Account> searchByUsername(String username) {
        return accountRepository.findByUsernameContainingIgnoreCase(username);  // Tìm tài khoản theo tên với phân biệt hoa thường
    }

    // Kiểm tra tồn tại tài khoản theo username
    public boolean existsByUsername(String username) {
        return accountRepository.existsByUsername(username);  // Kiểm tra username đã tồn tại chưa
    }

    // Kiểm tra tồn tại tài khoản theo email
    public boolean existsByEmail(String email) {
        return accountRepository.existsByEmail(email);  // Kiểm tra email đã tồn tại chưa
    }

    // Tìm tài khoản theo vai trò (ADMIN/USER)
    public List<Account> findByRole(Account.Role role) {
        return accountRepository.findByRole(role);  // Tìm tài khoản theo vai trò
    }
}
