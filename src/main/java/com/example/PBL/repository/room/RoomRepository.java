package com.example.PBL.repository.room;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.PBL.model.Room;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    
    // Tìm phòng theo khu vực
    List<Room> findByLocation(String location);
    
    // Tìm phòng theo loại (phòng trọ, căn hộ, nhà nguyên căn)
    List<Room> findByType(Room.RoomType type);

    // Tìm phòng theo giá
    List<Room> findByPriceBetween(double minPrice, double maxPrice);  // Tìm phòng theo giá từ minPrice đến maxPrice
    
    // Tìm phòng theo diện tích
    List<Room> findByAreaBetween(double minArea, double maxArea);  // Tìm phòng theo diện tích từ minArea đến maxArea

     // Tìm kiếm phòng theo location, giá, diện tích và loại phòng
     List<Room> findByLocationAndPriceBetweenAndAreaBetweenAndType(
        String locationId, Double minPrice, Double maxPrice, Integer minArea, Integer maxArea, String roomType);
    
    // Tìm tất cả các phòng trọ theo một loại phòng nhất định
    // Tìm phòng trọ theo tên chủ trọ (có thể tham chiếu tới tên hoặc ID của chủ trọ)
    List<Room> findByOwner_UserID(String userID);  // Tìm tất cả các phòng của chủ trọ theo ID người dùng
}
