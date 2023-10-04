package com.militaryaircraft.militaryaircraftapi.model.dto;


import com.militaryaircraft.militaryaircraftapi.model.entity.Aircraft;
import com.militaryaircraft.militaryaircraftapi.model.entity.AircraftImage;
import com.militaryaircraft.militaryaircraftapi.model.entity.AircraftVideo;
import com.militaryaircraft.militaryaircraftapi.model.entity.TechnicalSpecification;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class AircraftDto extends  BaseEntityDto {

    private Long id;

    private String name;

    private String manufacturer;

    private String servicePeriod;

    private String countryOfOrigin;

    private String promoPageURL;

    private Date serviceStartDate;

    private Date serviceEndDate;

    private CategoryDto category;

    private List<TechnicalSpecificationDto> technicalSpecifications;

    private List<AircraftImageDto> images;

    private List<AircraftVideoDto> videos;

    public AircraftDto() {
    }

    public AircraftDto(Aircraft aircraft) {
        this.id = aircraft.getId();
        this.name = aircraft.getName();
        this.manufacturer = aircraft.getManufacturer();
        this.servicePeriod = aircraft.getServicePeriod();
        this.countryOfOrigin = aircraft.getCountryOfOrigin();
        this.promoPageURL = aircraft.getPromoPageURL();
        this.serviceStartDate = aircraft.getServiceStartDate();
        this.serviceEndDate = aircraft.getServiceEndDate();
        this.category = new CategoryDto(aircraft.getCategory());
        this.technicalSpecifications = new ArrayList<>();
        for (TechnicalSpecification technicalSpecification : aircraft.getTechnicalSpecifications()) {
            this.technicalSpecifications.add(new TechnicalSpecificationDto(technicalSpecification));
        }
        this.images = new ArrayList<>();
        for (AircraftImage aircraftImage : aircraft.getImages()) {
            this.images.add(new AircraftImageDto(aircraftImage));
        }
        this.videos = new ArrayList<>();
        for (AircraftVideo aircraftVideo : aircraft.getVideos()) {
            this.videos.add(new AircraftVideoDto(aircraftVideo));
        }
    }
}
