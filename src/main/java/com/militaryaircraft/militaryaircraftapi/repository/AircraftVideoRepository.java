package com.militaryaircraft.militaryaircraftapi.repository;

import com.militaryaircraft.militaryaircraftapi.model.entity.AircraftVideo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AircraftVideoRepository extends JpaRepository<AircraftVideo, Long> {
    // Özel sorgular veya işlemler burada tanımlanabilir
}