package com.example.PBL.model;

import lombok.Data;

@Data
public class RoomModel {

    private String name;
    private String location;
    private Integer capacity;
    private Double price;
    private Long postId; // ID bài đăng của phòng trọ

}
