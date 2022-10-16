package com.ualace36.apicloud.controller;

import com.ualace36.apicloud.controller.mapper.ParkingMapper;
import com.ualace36.apicloud.model.Parking;
import com.ualace36.apicloud.model.dto.ParkingCreateDTO;
import com.ualace36.apicloud.model.dto.ParkingDTO;
import com.ualace36.apicloud.service.ParkingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    /**
     * @return Criação do Método FindById
     */
 @GetMapping("/{id}")
    public ResponseEntity<ParkingDTO> findById(@PathVariable String id){
    Parking parking=(Parking) parkingService.findById(id);
    ParkingDTO result = parkingMapper.toParkingDTO(parking);
        return ResponseEntity.ok(result);
    }
    @PostMapping
    public ResponseEntity<ParkingDTO> create(@RequestBody ParkingCreateDTO dto){
     var parkingCreate = parkingMapper.toParkinCreate(dto);
     var parking = parkingService.create(parkingCreate);
    var result = parkingMapper.toParkingDTO(parking);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

}
