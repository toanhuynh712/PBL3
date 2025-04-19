package com.example.PBL.model;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "post") // Tên bảng trong CSDL
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {

    @Id
    @UuidGenerator  // Để tự động tạo UUID cho post_id
    @Column(name = "post_id", columnDefinition = "VARCHAR(36)")
    private String postID;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    // Liên kết với bảng Room (1 Post có thể liên kết với 1 Room)
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Column(name = "rejection_reason", columnDefinition = "TEXT")
    private String rejectionReason;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    // Liên kết với bảng Image (1 Post có thể có nhiều hình ảnh)
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Image> imageUrls;

    // Liên kết với bảng Comment (1 Post có thể có nhiều bình luận)
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;

    // Liên kết với User (Mỗi Post có 1 User là chủ)
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    // Enum trạng thái bài đăng
    public enum Status {
        PENDING,
        APPROVED,
        REJECTED
    }
}
