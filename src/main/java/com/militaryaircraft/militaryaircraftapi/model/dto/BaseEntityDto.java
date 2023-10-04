package com.militaryaircraft.militaryaircraftapi.model.dto;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.io.Serializable;


@Data
@MappedSuperclass
public abstract class BaseEntityDto implements Serializable {
    private Long id;
}
