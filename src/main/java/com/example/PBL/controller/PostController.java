package com.example.PBL.controller;

import com.example.PBL.service.SearchService;
import com.example.PBL.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
public class PostController {

    
    @Autowired
    private SearchService searchService;

    @GetMapping("/search-posts")
    public String searchPosts(@RequestParam Double minPrice, 
                              @RequestParam Double maxPrice, 
                              @RequestParam Double minArea, 
                              @RequestParam Double maxArea, 
                              @RequestParam String roomType, 
                              @RequestParam String locationId, 
                              Model model) {

        // Gọi phương thức tìm kiếm bài đăng
        List<Post> posts = searchService.searchPostsByCriteria(minPrice, maxPrice, minArea, maxArea, roomType, locationId);

        model.addAttribute("posts", posts);
        return "search-results";  // Trả về view để hiển thị kết quả tìm kiếm
    }
}
