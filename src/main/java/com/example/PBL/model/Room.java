package com.example.PBL.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "room")
@Data
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id", columnDefinition = "VARCHAR(36)")  // Định nghĩa kiểu dữ liệu cho room_id
    private String roomID;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private double area;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoomType type;  // Enum cho loại phòng (PHONG_TRO, NHA_NGUYEN_CAN, CAN_HO)

    @ManyToOne
    @JoinColumn(name = "location_id", referencedColumnName = "location_id")  // Liên kết với bảng Location
    private Location location;  // Đổi từ String thành Location

    private String amenities;  // Tiện nghi mô tả dạng text
    private boolean isAvailable = true;  // Mặc định là có sẵn
    private int numberOfRooms = 1;  // Mặc định có 1 phòng

    public enum RoomType {
        PHONG_TRO,
        NHA_NGUYEN_CAN,
        CAN_HO
    }
}
