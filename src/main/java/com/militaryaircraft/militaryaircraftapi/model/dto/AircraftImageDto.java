package com.militaryaircraft.militaryaircraftapi.model.dto;

import com.militaryaircraft.militaryaircraftapi.model.entity.AircraftImage;
import lombok.Data;


@Data
public class AircraftImageDto {

    private Long id;

    private String imageURL;

    private String imageDescription;

    public AircraftImageDto() {
    }

    public AircraftImageDto(AircraftImage aircraftImage) {
        this.id = aircraftImage.getId();
        this.imageURL = aircraftImage.getImageURL();
        this.imageDescription = aircraftImage.getImageDescription();
    }

}