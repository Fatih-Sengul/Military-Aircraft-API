package com.militaryaircraft.militaryaircraftapi.service;


import com.militaryaircraft.militaryaircraftapi.mappers.AircraftVideoMapper;
import com.militaryaircraft.militaryaircraftapi.model.dto.AircraftVideoDto;
import com.militaryaircraft.militaryaircraftapi.model.entity.AircraftVideo;
import com.militaryaircraft.militaryaircraftapi.repository.AircraftVideoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AircraftVideoService {
    private final AircraftVideoRepository videoRepository;
    private final AircraftVideoMapper videoMapper;

    @Autowired
    public AircraftVideoService(AircraftVideoRepository videoRepository, AircraftVideoMapper videoMapper) {
        this.videoRepository = videoRepository;
        this.videoMapper = videoMapper;
    }

    public List<AircraftVideoDto> getAllVideos() {
        List<AircraftVideo> videos = videoRepository.findAll();
        return videos.stream()
                .map(videoMapper::toDto)
                .collect(Collectors.toList());
    }




    public AircraftVideoDto getVideoById(Long id) {
        AircraftVideo video = videoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Aircraft Video not found with id: " + id));
        return videoMapper.toDto(video);
    }

    public AircraftVideoDto createVideo(AircraftVideoDto videoDto) {
        AircraftVideo video = videoMapper.toEntity(videoDto);
        video = videoRepository.save(video);
        return videoMapper.toDto(video);
    }

    public AircraftVideoDto updateVideo(Long id, AircraftVideoDto updatedVideoDto) {
        AircraftVideo existingVideo = videoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Aircraft Video not found with id: " + id));

        // Tüm alanları güncelle
        existingVideo.setVideoURL(updatedVideoDto.getVideoURL());
        existingVideo.setVideoDescription(updatedVideoDto.getVideoDescription());

        AircraftVideo updatedVideo = videoRepository.save(existingVideo);
        return videoMapper.toDto(updatedVideo);
    }

    public void deleteVideo(Long id) {
        AircraftVideo video = videoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Aircraft Video not found with id: " + id));
        videoRepository.delete(video);
    }
}
