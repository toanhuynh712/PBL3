package com.example.PBL.service;

import java.util.List;
import java.util.Optional;

import com.example.PBL.model.*;

public interface UserService {

     // Đăng bài
     Post createPost(String userId, Post post);

     // Sửa bài đăng
     Post updatePost(String userId, String postId, Post updatedPost);
 
     // Xóa bài đăng
     boolean deletePost(String userId, String postId);
 
     // Thêm bình luận vào bài đăng
     Comment addComment(String userId, String postId, String content);
 
     // Lấy thông tin người dùng
     Optional<User> getUserInfo(String userId);
 
     // Cập nhật thông tin người dùng
     User updateUserInfo(String userId, User userDetails);
 
     // Tìm kiếm bài đăng/phòng theo nhiều tiêu chí
     List<Post> searchPosts(String location, Double minPrice, Double maxPrice,
                            Double minArea, Double maxArea, String roomType);
 
     // Lấy danh sách bài đăng cá nhân của user
     List<Post> getUserPosts(String userId);
}
