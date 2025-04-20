package com.example.PBL.service;

import com.example.PBL.model.Location;
import com.example.PBL.model.Post;
import com.example.PBL.model.Room;
import com.example.PBL.repository.room.LocationRepository;
import com.example.PBL.repository.post.PostRepository;
import com.example.PBL.repository.room.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private LocationRepository locationRepository;

    // Tìm kiếm bài đăng theo các tiêu chí
    public List<Post> searchPostsByCriteria(Double minPrice, Double maxPrice, 
                                             Double minArea, Double maxArea, 
                                             String roomType, String locationId) {

        // Chuyển roomType từ String thành Room.RoomType enum
        Room.RoomType type = Room.RoomType.valueOf(roomType);

        return postRepository.findByRoom_PriceBetweenAndRoom_AreaBetweenAndRoom_TypeAndRoom_Location_LocationId(
                minPrice, maxPrice, minArea, maxArea, type, locationId);
    }
}
