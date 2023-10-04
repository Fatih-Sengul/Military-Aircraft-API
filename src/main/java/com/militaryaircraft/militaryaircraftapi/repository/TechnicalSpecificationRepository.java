package com.militaryaircraft.militaryaircraftapi.repository;


import com.militaryaircraft.militaryaircraftapi.model.entity.TechnicalSpecification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicalSpecificationRepository extends JpaRepository<TechnicalSpecification, Long> {
    // Özel sorgular veya işlemler burada tanımlanabilir
}
