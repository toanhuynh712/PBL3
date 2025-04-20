package com.example.PBL.model;

import jakarta.persistence.*;

@Entity
@Table(name = "room")
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

    // Getter and Setter for roomID
    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    // Getter and Setter for price
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Getter and Setter for area
    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    // Getter and Setter for type
    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    // Getter and Setter for location
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    // Getter and Setter for amenities
    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    // Getter and Setter for isAvailable
    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    // Getter and Setter for numberOfRooms
    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }
}
