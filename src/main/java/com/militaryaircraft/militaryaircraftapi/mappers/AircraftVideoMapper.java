package com.militaryaircraft.militaryaircraftapi.mappers;

import com.militaryaircraft.militaryaircraftapi.model.dto.AircraftVideoDto;
import com.militaryaircraft.militaryaircraftapi.model.entity.AircraftVideo;
import org.mapstruct.Mapper;

@Mapper
public interface AircraftVideoMapper {

    AircraftVideo toEntity(AircraftVideoDto aircraftVideoDto);

    AircraftVideoDto toDto(AircraftVideo aircraftVideo);
}
