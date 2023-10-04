package com.militaryaircraft.militaryaircraftapi.repository;

import com.militaryaircraft.militaryaircraftapi.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    // Özel sorgular veya işlemler burada tanımlanabilir
}