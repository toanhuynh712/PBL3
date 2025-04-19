package com.example.PBL.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "Location") // 👈 chỉ rõ tên bảng trong DB
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    public Location(String name, LocationType type, String parentId) {
        this.name = name;
        this.type = type;
        this.parentId = parentId;
    }

    @PrePersist
    public void generateId() {
        if (this.locationId == null) {
            this.locationId = UUID.randomUUID().toString();
        }
    }
}
