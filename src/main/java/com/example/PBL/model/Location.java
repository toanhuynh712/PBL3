package com.example.PBL.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "Location") // 👈 chỉ rõ tên bảng trong DB
public class Location {

    @Id
    @Column(name = "location_id", length = 36)
    private String locationId;

    private String name;

    @Enumerated(EnumType.STRING)
    private LocationType type;

    @Column(name = "parent_id")
    private String parentId;

    @ManyToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "location_id", insertable = false, updatable = false)
    private Location parentLocation;

    public enum LocationType {
        CITY, DISTRICT
    }

    // Constructor for creating Location with name, type, and parentId
    public Location(String name, LocationType type, String parentId) {
        this.name = name;
        this.type = type;
        this.parentId = parentId;
    }

    // Getter and Setter for locationId
    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for type
    public LocationType getType() {
        return type;
    }

    public void setType(LocationType type) {
        this.type = type;
    }

    // Getter and Setter for parentId
    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    // Getter and Setter for parentLocation
    public Location getParentLocation() {
        return parentLocation;
    }

    public void setParentLocation(Location parentLocation) {
        this.parentLocation = parentLocation;
    }

    @PrePersist
    public void generateId() {
        if (this.locationId == null) {
            this.locationId = UUID.randomUUID().toString();
        }
    }
}
