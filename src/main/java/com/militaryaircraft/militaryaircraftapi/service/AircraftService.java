package com.militaryaircraft.militaryaircraftapi.service;


import com.militaryaircraft.militaryaircraftapi.mappers.*;
import com.militaryaircraft.militaryaircraftapi.model.dto.AircraftDto;
import com.militaryaircraft.militaryaircraftapi.model.entity.Aircraft;
import com.militaryaircraft.militaryaircraftapi.model.entity.AircraftImage;
import com.militaryaircraft.militaryaircraftapi.model.entity.AircraftVideo;
import com.militaryaircraft.militaryaircraftapi.model.entity.TechnicalSpecification;
import com.militaryaircraft.militaryaircraftapi.repository.AircraftRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class AircraftService {

    private final AircraftRepository aircraftRepository;
    private final AircraftMapper aircraftMapper;
    private final CategoryMapper categoryMapper;
    private final TechnicalSpecificationMapper technicalSpecificationMapper;
    private final AircraftImageMapper aircraftImageMapper;
    private final AircraftVideoMapper aircraftVideoMapper;

    @Autowired
    public AircraftService(
            AircraftRepository aircraftRepository,
            AircraftMapper aircraftMapper,
            CategoryMapper categoryMapper,
            TechnicalSpecificationMapper technicalSpecificationMapper,
            AircraftImageMapper aircraftImageMapper,
            AircraftVideoMapper aircraftVideoMapper
    ) {
        this.aircraftRepository = aircraftRepository;
        this.aircraftMapper = aircraftMapper;
        this.categoryMapper = categoryMapper;
        this.technicalSpecificationMapper = technicalSpecificationMapper;
        this.aircraftImageMapper = aircraftImageMapper;
        this.aircraftVideoMapper = aircraftVideoMapper;
    }

    public AircraftDto getAircraftById(Long aircraftId) {
        Aircraft aircraft = aircraftRepository.findById(aircraftId)
                .orElseThrow(() -> new EntityNotFoundException("Aircraft not found with id: " + aircraftId));
        return aircraftMapper.toDto(aircraft);
    }

    public List<AircraftDto> getAllAircraft() {
        List<Aircraft> aircraftList = aircraftRepository.findAll();
        return aircraftList.stream()
                .map(aircraftMapper::toDto)
                .collect(Collectors.toList());
    }

    public AircraftDto createAircraft(AircraftDto aircraftDto) {
        Aircraft aircraft = aircraftMapper.toEntity(aircraftDto);
        Aircraft savedAircraft = aircraftRepository.save(aircraft);
        return aircraftMapper.toDto(savedAircraft);
    }

    public AircraftDto updateAircraft(Long aircraftId, AircraftDto updatedAircraftDto) {
        Aircraft existingAircraft = aircraftRepository.findById(aircraftId)
                .orElseThrow(() -> new EntityNotFoundException("Aircraft not found with id: " + aircraftId));

        // Tüm alanları güncelle
        existingAircraft.setName(updatedAircraftDto.getName());
        existingAircraft.setManufacturer(updatedAircraftDto.getManufacturer());
        existingAircraft.setServicePeriod(updatedAircraftDto.getServicePeriod());
        existingAircraft.setCountryOfOrigin(updatedAircraftDto.getCountryOfOrigin());
        existingAircraft.setPromoPageURL(updatedAircraftDto.getPromoPageURL());
        existingAircraft.setServiceStartDate(updatedAircraftDto.getServiceStartDate());
        existingAircraft.setServiceEndDate(updatedAircraftDto.getServiceEndDate());
        existingAircraft.setCategory(categoryMapper.toEntity(updatedAircraftDto.getCategory())); // Eğer kategori DTO'sunu entity'ye çevirmeniz gerekiyorsa

        // Teknik özellikleri güncelle
        List<TechnicalSpecification> updatedSpecifications = updatedAircraftDto.getTechnicalSpecifications()
                .stream()
                .map(technicalSpecificationMapper::toEntity)
                .collect(Collectors.toList());
        existingAircraft.setTechnicalSpecifications(updatedSpecifications);

        // Resimleri güncelle
        List<AircraftImage> updatedImages = updatedAircraftDto.getImages()
                .stream()
                .map(aircraftImageMapper::toEntity)
                .collect(Collectors.toList());
        existingAircraft.setImages(updatedImages);

        // Videoları güncelle
        List<AircraftVideo> updatedVideos = updatedAircraftDto.getVideos()
                .stream()
                .map(aircraftVideoMapper::toEntity)
                .collect(Collectors.toList());
        existingAircraft.setVideos(updatedVideos);

        Aircraft updatedAircraft = aircraftRepository.save(existingAircraft);
        return aircraftMapper.toDto(updatedAircraft);
    }


    public void deleteAircraft(Long aircraftId) {
        Aircraft aircraft = aircraftRepository.findById(aircraftId)
                .orElseThrow(() -> new EntityNotFoundException("Aircraft not found with id: " + aircraftId));

        // Silme işlemi
        aircraftRepository.delete(aircraft);
    }

}