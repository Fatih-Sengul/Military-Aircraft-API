package com.militaryaircraft.militaryaircraftapi.repository;


import com.militaryaircraft.militaryaircraftapi.model.entity.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AircraftRepository extends JpaRepository<Aircraft, Long> {
    List<Aircraft> findByCategoryCategoryName(String categoryName);
}
