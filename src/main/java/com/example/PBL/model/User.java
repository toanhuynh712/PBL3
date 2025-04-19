package com.example.PBL.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", columnDefinition = "VARCHAR(36)")  // Nếu bạn muốn dùng UUID, chuyển sang UUID
    private String userID;  // UUID (VARCHAR(36))

    @Column(nullable = false, length = 100)
    private String name;

    @Column(name = "birth_date")
    private LocalDate birthDate;  // Sử dụng LocalDate thay vì Date nếu không cần thời gian

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Column(name = "phone_number", length = 15)
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "accountID")
    private Account account;  // Liên kết với bảng Account

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Post> myPosts;  // Liên kết với bảng Post (những bài đăng của người dùng)

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Comment> myComments;  // Liên kết với bảng Comment (bình luận của người dùng)

    public enum Gender {
        MALE,
        FEMALE,
        OTHER
    }

    public boolean isAdmin() {
        return account != null && account.getRole() == Account.Role.ADMIN;  // Kiểm tra xem người dùng có phải là admin không
    }

}
