package com.example.PBL.repository.room;

import com.example.PBL.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, String> {

    // Tìm kiếm Location theo tên
    List<Location> findByNameContainingIgnoreCase(String name);

    // Tìm kiếm Location theo loại (CITY hoặc DISTRICT)
    List<Location> findByType(Location.LocationType type);

    // Tìm kiếm Location theo tên và loại
    List<Location> findByNameContainingIgnoreCaseAndType(String name, Location.LocationType type);

    // Tìm kiếm tất cả các Location con của một Location cha (parentId)
    List<Location> findByParentId(String parentId);

    // Tìm kiếm Location theo LocationId
    Location findByLocationId(String locationId);
}
