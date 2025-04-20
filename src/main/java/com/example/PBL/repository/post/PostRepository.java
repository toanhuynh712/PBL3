    package com.example.PBL.repository.post;

    import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.PBL.model.Post;
import com.example.PBL.model.Room;
import com.example.PBL.model.Room.RoomType;
import com.example.PBL.model.Location;


import java.util.List;

    public interface PostRepository extends JpaRepository<Post, Long> {

        // Tìm bài đăng theo trạng thái (PENDING, APPROVED, REJECTED)
        List<Post> findByStatus(Post.Status status);

        @Query("SELECT p FROM Post p WHERE " +
       "(:location IS NULL OR p.room.location LIKE %:location%) AND " +
       "(:minPrice IS NULL OR p.room.price >= :minPrice) AND " +
       "(:maxPrice IS NULL OR p.room.price <= :maxPrice) AND " +
       "(:minArea IS NULL OR p.room.area >= :minArea) AND " +
       "(:maxArea IS NULL OR p.room.area <= :maxArea) AND " +
       "(:roomType IS NULL OR p.room.type = :roomType) AND " +
       "p.status = 'APPROVED'")
List<Post> searchRooms(@Param("location") String location,
                       @Param("minPrice") Double minPrice,
                       @Param("maxPrice") Double maxPrice,
                       @Param("minArea") Double minArea,
                       @Param("maxArea") Double maxArea,
                       @Param("roomType") String roomType);

        
        // Tìm bài đăng theo người đăng
        List<Post> findByUser_Id(String userId);  // Tìm tất cả bài đăng của một user theo userID
        
        // Tìm bài đăng theo trạng thái và người đăng
        List<Post> findByStatusAndOwner_UserID(Post.Status status, String userID);  // Tìm bài đăng của một user với trạng thái

        // Tìm bài đăng theo tiêu đề (tìm kiếm bài đăng theo tiêu đề)
        List<Post> findByTitleContaining(String title);  // Tìm bài đăng theo tiêu đề chứa từ khóa
        // Tìm kiếm bài đăng theo giá, diện tích, loại phòng và location      
        List<Post> findByRoom_PriceBetweenAndRoom_AreaBetweenAndRoom_TypeAndRoom_Location_LocationId(
            Double minPrice, 
            Double maxPrice, 
            Double minArea, 
            Double maxArea, 
            Room.RoomType roomType, 
            String locationId);
}
    
    
