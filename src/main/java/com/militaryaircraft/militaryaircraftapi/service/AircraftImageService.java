package com.militaryaircraft.militaryaircraftapi.service;

import com.militaryaircraft.militaryaircraftapi.mappers.AircraftImageMapper;
import com.militaryaircraft.militaryaircraftapi.model.dto.AircraftImageDto;
import com.militaryaircraft.militaryaircraftapi.model.entity.AircraftImage;
import com.militaryaircraft.militaryaircraftapi.repository.AircraftImageRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AircraftImageService {
    private final AircraftImageRepository imageRepository;
    private final AircraftImageMapper imageMapper;

    @Autowired
    public AircraftImageService(AircraftImageRepository imageRepository, AircraftImageMapper imageMapper) {
        this.imageRepository = imageRepository;
        this.imageMapper = imageMapper;
    }

    public List<AircraftImageDto> getAllImages() {
        List<AircraftImage> images = imageRepository.findAll();
        return images.stream()
                .map(imageMapper::toDto)
                .collect(Collectors.toList());
    }

    public AircraftImageDto getImageById(Long id) {
        AircraftImage image = imageRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Aircraft Image not found with id: " + id));
        return imageMapper.toDto(image);
    }

    public AircraftImageDto createImage(AircraftImageDto imageDto) {
        AircraftImage image = imageMapper.toEntity(imageDto);
        image = imageRepository.save(image);
        return imageMapper.toDto(image);
    }

    public AircraftImageDto updateImage(Long id, AircraftImageDto updatedImageDto) {
        AircraftImage existingImage = imageRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Aircraft Image not found with id: " + id));

        existingImage.setImageURL(updatedImageDto.getImageURL());
        existingImage.setImageDescription(updatedImageDto.getImageDescription());

        AircraftImage updatedImage = imageRepository.save(existingImage);
        return imageMapper.toDto(updatedImage);
    }

    public void deleteImage(Long id) {
        AircraftImage image = imageRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Aircraft Image not found with id: " + id));

        imageRepository.delete(image);
    }
}

