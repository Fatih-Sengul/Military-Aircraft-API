package com.militaryaircraft.militaryaircraftapi.mappers;

import com.militaryaircraft.militaryaircraftapi.model.dto.TechnicalSpecificationDto;
import com.militaryaircraft.militaryaircraftapi.model.entity.TechnicalSpecification;
import org.mapstruct.Mapper;

@Mapper
public interface TechnicalSpecificationMapper {

    TechnicalSpecification toEntity(TechnicalSpecificationDto technicalSpecificationDto);

    TechnicalSpecificationDto toDto(TechnicalSpecification technicalSpecification);
}
