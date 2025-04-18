package com.example.PBL.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentModel {
    private String commentID;
    private String content;
    private Date createdAt;
    private UserModel author;  // Tác giả của bình luận
    private PostModel post;    // Bài đăng mà bình luận này liên quan đến
}
