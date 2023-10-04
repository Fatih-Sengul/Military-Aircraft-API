package com.militaryaircraft.militaryaircraftapi.model.dto;


import com.militaryaircraft.militaryaircraftapi.model.entity.AircraftVideo;
import lombok.Data;


@Data
public class AircraftVideoDto {

    private Long id;

    private String videoURL;

    private String videoDescription;

    public AircraftVideoDto() {
    }

    public AircraftVideoDto(AircraftVideo aircraftVideo) {
        this.id = aircraftVideo.getId();
        this.videoURL = aircraftVideo.getVideoURL();
        this.videoDescription = aircraftVideo.getVideoDescription();
    }

}
