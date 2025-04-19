package com.example.PBL.service;

import java.util.List;

import com.example.PBL.model.Post;

public interface SearchService {
    List<Post> searchRooms(String location, Double minPrice, Double maxPrice, Double minArea, Double maxArea, String roomType);
}