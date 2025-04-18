package com.example.PBL.repository;

import com.example.PBL.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface PostRepository extends JpaRepository<Post, Long> {
    // Các phương thức truy vấn đặc biệt (nếu cần) có thể thêm vào đây
    List<Post> findByStatus(Post.Status status);  // Tìm bài đăng theo trạng thái (PENDING, APPROVED, REJECTED)
}
