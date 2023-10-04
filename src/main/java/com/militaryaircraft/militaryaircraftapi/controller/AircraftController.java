package com.militaryaircraft.militaryaircraftapi.controller;


import com.militaryaircraft.militaryaircraftapi.model.dto.AircraftDto;
import com.militaryaircraft.militaryaircraftapi.service.AircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/aircrafts")
public class AircraftController {

    private final AircraftService aircraftService;

    @Autowired
    public AircraftController(AircraftService aircraftService) {
        this.aircraftService = aircraftService;
    }

    @GetMapping("/{id}")
    public AircraftDto getAircraftById(@PathVariable Long id) {
        return aircraftService.getAircraftById(id);
    }

    @GetMapping
    public List<AircraftDto> getAllAircrafts() {
        return aircraftService.getAllAircraft();
    }

    @PostMapping
    public AircraftDto createAircraft(@RequestBody AircraftDto aircraftDto) {
        return aircraftService.createAircraft(aircraftDto);
    }

    @PutMapping("/{id}")
    public AircraftDto updateAircraft(@PathVariable Long id, @RequestBody AircraftDto updatedAircraftDto) {
        return aircraftService.updateAircraft(id, updatedAircraftDto);
    }

    @DeleteMapping("/{id}")
    public void deleteAircraft(@PathVariable Long id) {
        aircraftService.deleteAircraft(id);
    }
}

