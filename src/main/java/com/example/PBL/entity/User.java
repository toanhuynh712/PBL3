package com.example.PBL.model;

import jakarta.persistence.*;
import com.example.PBL.model.Account;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;

    private String name;
    private Date birthDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "accountID")
    private Account account;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Post> myPosts;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Comment> myComments;

    public enum Gender {
        MALE,
        FEMALE,
        OTHER
    }

    public boolean isAdmin() {
        return account.getRole() == Account.Role.ADMIN;
    }
}
