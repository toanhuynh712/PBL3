package com.example.PBL.repository.post;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.PBL.model.Comment;
import com.example.PBL.model.Post;
import com.example.PBL.model.User;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    // Tìm các bình luận theo ID bài đăng
    List<Comment> findByPostId(Long postId);  
    
    // Tìm các bình luận theo người dùng
    List<Comment> findByAuthor(User author);
    
    // Tìm các bình luận theo bài đăng và trạng thái bài đăng
    List<Comment> findByPostAndPostStatus(Post post, Post.Status status);

    // Tìm bình luận theo bài đăng và người dùng
    List<Comment> findByPostAndAuthor(Post post, User author);

    // Tìm bình luận theo nội dung
    List<Comment> findByContentContaining(String keyword);  // Tìm bình luận có chứa từ khóa

    // Tìm bình luận theo trạng thái bài đăng và người dùng
    List<Comment> findByPostStatusAndAuthor(Post.Status status, User author);
    
    // Lấy bình luận theo ID
    Optional<Comment> findById(Long commentId);
}
