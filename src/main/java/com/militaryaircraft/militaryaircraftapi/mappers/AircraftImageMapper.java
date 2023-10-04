package com.militaryaircraft.militaryaircraftapi.mappers;

import com.militaryaircraft.militaryaircraftapi.model.dto.AircraftImageDto;
import com.militaryaircraft.militaryaircraftapi.model.entity.AircraftImage;
import org.mapstruct.Mapper;

@Mapper
public interface AircraftImageMapper {

    AircraftImage toEntity(AircraftImageDto aircraftImageDto);

    AircraftImageDto toDto(AircraftImage aircraftImage);
}
