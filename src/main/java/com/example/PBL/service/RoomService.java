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

    // Tìm kiếm bài đăng phòng trọ theo tiêu chí
    public List<Post> searchPosts(Location location, Room.RoomType roomType, Double minPrice, Double maxPrice, Double minArea, Double maxArea) {
        return postRepository.findByRoom_LocationAndRoom_TypeAndRoom_PriceBetweenAndRoom_AreaBetween(
            location, roomType, minPrice, maxPrice, minArea, maxArea
        );
    }
    

    // Tìm kiếm vị trí (city hoặc district) theo tên
    public List<Location> searchLocations(String keyword) {
        return locationRepository.searchByName(keyword);
    }
}
