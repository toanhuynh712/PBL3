package com.example.PBL.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "room")
@Data
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomID;

    private double price;
    private double area;

    @Enumerated(EnumType.STRING)
    private RoomType type;     // Enum cho loại phòng (PHONG_TRO, NHA_NGUYEN_CAN, CAN_HO)

    private String location;
    private String amenities;  // Tiện nghi mô tả dạng text
    private boolean isAvailable;
    private int numberOfRooms;

    public enum RoomType {
        PHONG_TRO,
        NHA_NGUYEN_CAN,
        CAN_HO
    }
}
