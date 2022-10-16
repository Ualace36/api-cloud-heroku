package com.ualace36.apicloud.controller;

import com.ualace36.apicloud.controller.mapper.ParkingMapper;
import com.ualace36.apicloud.model.Parking;
import com.ualace36.apicloud.model.dto.ParkingDTO;
import com.ualace36.apicloud.service.ParkingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/parking")
public class ParkingController {

    private final ParkingService parkingService;
    private final ParkingMapper parkingMapper;
    public ParkingController(ParkingService parkingService, ParkingMapper parkingMapper) {
        this.parkingService = parkingService;
        this.parkingMapper = parkingMapper;
    }

    @GetMapping
    public ResponseEntity<List<ParkingDTO>> findAll(){
        List<Parking> parkingList = parkingService.findAll();
        List<ParkingDTO> result = parkingMapper.toParkingDTOToList(parkingList);
        return ResponseEntity.ok(result);
    }

}
