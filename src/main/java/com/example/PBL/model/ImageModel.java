package com.example.PBL.model;
import lombok.Data;

@Data
public class ImageModel {

    private String imageID;
    private String imageUrl;  // Đường dẫn tới ảnh lưu trên server hoặc lưu trữ đám mây
    private PostModel post;   // Liên kết với bài đăng (phòng cho thuê) mà ảnh này thuộc về

}
