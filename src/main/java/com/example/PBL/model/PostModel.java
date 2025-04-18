package com.example.PBL.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostModel {
    private String postID;
    private String title;
    private String description;
    private RoomModel room;             // Liên kết với phòng cụ thể
    private Status status;
    private String rejectionReason;
    private Date createdAt;
    private List<String> imageUrls;
    private UserModel user;            // Người đăng bài

    public enum Status {
        PENDING,
        APPROVED,
        REJECTED
    }
}
