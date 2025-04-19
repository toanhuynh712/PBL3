package com.example.PBL.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "room")
@Data
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String roomID;

    private double price;
    private double area;

    @Enumerated(EnumType.STRING)
    private RoomType type;     // Enum cho loại phòng (PHONG_TRO, NHA_NGUYEN_CAN, CAN_HO)

    @ManyToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id")  // Liên kết với bảng Location qua trường location_id
    private Location location;  // Đổi từ String thành Location

    private String amenities;  // Tiện nghi mô tả dạng text
    private boolean isAvailable;
    private int numberOfRooms;

    public enum RoomType {
        PHONG_TRO,
        NHA_NGUYEN_CAN,
        CAN_HO
    }
}
