package com.militaryaircraft.militaryaircraftapi.repository;

import com.militaryaircraft.militaryaircraftapi.model.entity.AircraftImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AircraftImageRepository extends JpaRepository<AircraftImage, Long> {
    // Özel sorgular veya işlemler burada tanımlanabilir
}
