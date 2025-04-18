package com.example.PBL.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "account")
@Data // Tự động tạo getter, setter, toString, equals, hashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder // Cho phép sử dụng pattern Builder khi khởi tạo
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountID;

    private String username;
    private String password;
    private String email;
    private Date createdAt;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Role {
        USER, ADMIN
    }

    public enum Status {
        ACTIVE, LOCKED
    }
    public Role getRole() {
        return this.role;
    }
}
