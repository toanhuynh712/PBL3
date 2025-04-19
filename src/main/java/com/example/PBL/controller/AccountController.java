package com.example.PBL.controller;

import com.example.PBL.model.Account;
import com.example.PBL.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    // Đăng ký tài khoản mới
    @PostMapping("/register")
    public ResponseEntity<Account> registerAccount(@RequestBody Account account) {
        Account createdAccount = accountService.registerAccount(account);
        return ResponseEntity.ok(createdAccount);
    }

    // Cập nhật trạng thái tài khoản (lock/unlock)
    @PatchMapping("/status/{accountID}")
    public ResponseEntity<String> updateAccountStatus(@PathVariable Long accountID, @RequestParam Account.Status status) {
        accountService.updateAccountStatus(accountID, status);
        return ResponseEntity.ok("Account status updated successfully");
    }

    // Tìm tài khoản theo username (dùng phương thức tự động sinh ra)
    @GetMapping("/username/{username}")
    public ResponseEntity<Account> getAccountByUsername(@PathVariable String username) {
        Account account = accountService.findByUsername(username);
        return account != null ? ResponseEntity.ok(account) : ResponseEntity.notFound().build();
    }

    // Tìm tài khoản theo email
    @GetMapping("/email/{email}")
    public ResponseEntity<Account> getAccountByEmail(@PathVariable String email) {
        Optional<Account> account = accountService.findByEmail(email);
        return account.isPresent() ? ResponseEntity.ok(account.get()) : ResponseEntity.notFound().build();
    }

    // Tìm tài khoản theo trạng thái
    @GetMapping("/status")
    public ResponseEntity<List<Account>> getAccountsByStatus(@RequestParam Account.Status status) {
        List<Account> accounts = accountService.findByStatus(status);
        return ResponseEntity.ok(accounts);
    }

    // Tìm tài khoản theo tên (dùng phương thức tự động sinh ra với phân trang)
    @GetMapping("/search")
    public ResponseEntity<List<Account>> searchAccountsByUsername(@RequestParam String username) {
        List<Account> accounts = accountService.findByUsernameContainingIgnoreCase(username);
        return ResponseEntity.ok(accounts);
    }

    // Kiểm tra tồn tại tài khoản theo username (dùng phương thức tự động sinh ra)
    @GetMapping("/exists/username/{username}")
    public ResponseEntity<Boolean> checkUsernameExistence(@PathVariable String username) {
        boolean exists = accountService.existsByUsername(username);
        return ResponseEntity.ok(exists);
    }

    // Kiểm tra tồn tại tài khoản theo email (dùng phương thức tự động sinh ra)
    @GetMapping("/exists/email/{email}")
    public ResponseEntity<Boolean> checkEmailExistence(@PathVariable String email) {
        boolean exists = accountService.existsByEmail(email);
        return ResponseEntity.ok(exists);
    }

}
