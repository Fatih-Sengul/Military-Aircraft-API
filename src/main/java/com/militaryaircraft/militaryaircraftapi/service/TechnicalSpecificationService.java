package com.militaryaircraft.militaryaircraftapi.service;


import com.militaryaircraft.militaryaircraftapi.mappers.TechnicalSpecificationMapper;
import com.militaryaircraft.militaryaircraftapi.model.dto.TechnicalSpecificationDto;
import com.militaryaircraft.militaryaircraftapi.model.entity.TechnicalSpecification;
import com.militaryaircraft.militaryaircraftapi.repository.TechnicalSpecificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TechnicalSpecificationService {

    private final TechnicalSpecificationMapper technicalSpecificationMapper;
    private final TechnicalSpecificationRepository technicalSpecificationRepository;

    @Autowired
    public TechnicalSpecificationService(TechnicalSpecificationMapper technicalSpecificationMapper, TechnicalSpecificationRepository technicalSpecificationRepository) {
        this.technicalSpecificationMapper = technicalSpecificationMapper;
        this.technicalSpecificationRepository = technicalSpecificationRepository;
    }

    public TechnicalSpecificationDto createTechnicalSpecification(TechnicalSpecificationDto dto) {
        TechnicalSpecification entity = technicalSpecificationMapper.toEntity(dto);
        TechnicalSpecification savedEntity = technicalSpecificationRepository.save(entity);
        return technicalSpecificationMapper.toDto(savedEntity);
    }

    public TechnicalSpecificationDto getTechnicalSpecificationById(Long id) {
        Optional<TechnicalSpecification> optional = technicalSpecificationRepository.findById(id);
        return optional.map(technicalSpecificationMapper::toDto).orElse(null);
    }

    public TechnicalSpecificationDto updateTechnicalSpecification(Long id, TechnicalSpecificationDto dto) {
        Optional<TechnicalSpecification> optional = technicalSpecificationRepository.findById(id);
        if (optional.isPresent()) {
            TechnicalSpecification entity = technicalSpecificationMapper.toEntity(dto);
            entity.setId(id);
            TechnicalSpecification updatedEntity = technicalSpecificationRepository.save(entity);
            return technicalSpecificationMapper.toDto(updatedEntity);
        } else {
            return null;
        }
    }

    public boolean deleteTechnicalSpecification(Long id) {
        Optional<TechnicalSpecification> optional = technicalSpecificationRepository.findById(id);
        if (optional.isPresent()) {
            technicalSpecificationRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
