package com.example.PBL.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "users")
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
        return account != null && account.getRole() != null && account.getRole() == Account.Role.ADMIN;
    }

    // Getter and Setter methods

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Post> getMyPosts() {
        return myPosts;
    }

    public void setMyPosts(List<Post> myPosts) {
        this.myPosts = myPosts;
    }

    public List<Comment> getMyComments() {
        return myComments;
    }

    public void setMyComments(List<Comment> myComments) {
        this.myComments = myComments;
    }
}
