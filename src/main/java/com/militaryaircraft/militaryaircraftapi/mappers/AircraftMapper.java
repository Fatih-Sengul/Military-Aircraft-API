package com.militaryaircraft.militaryaircraftapi.mappers;

import com.militaryaircraft.militaryaircraftapi.model.dto.AircraftDto;
import com.militaryaircraft.militaryaircraftapi.model.entity.Aircraft;
import org.mapstruct.Mapper;

@Mapper
public interface AircraftMapper {

    Aircraft toEntity(AircraftDto aircraftDto);

    AircraftDto toDto(Aircraft aircraft);
}
