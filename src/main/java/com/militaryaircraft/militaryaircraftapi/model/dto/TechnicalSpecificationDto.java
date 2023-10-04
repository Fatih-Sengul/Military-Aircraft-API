package com.militaryaircraft.militaryaircraftapi.model.dto;


import com.militaryaircraft.militaryaircraftapi.model.entity.TechnicalSpecification;
import lombok.Data;


@Data
public class TechnicalSpecificationDto {

    private Long id;

    private String armament;

    private String powerSystem;

    private double speed;

    private double range;

    public TechnicalSpecificationDto() {
    }

    public TechnicalSpecificationDto(TechnicalSpecification technicalSpecification) {
        this.id = technicalSpecification.getId();
        this.armament = technicalSpecification.getArmament();
        this.powerSystem = technicalSpecification.getPowerSystem();
        this.speed = technicalSpecification.getSpeed();
        this.range = technicalSpecification.getRange();
    }
}