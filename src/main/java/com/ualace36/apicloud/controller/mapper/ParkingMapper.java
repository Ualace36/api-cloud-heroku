package com.ualace36.apicloud.controller.mapper;

import com.ualace36.apicloud.model.Parking;
import com.ualace36.apicloud.model.dto.ParkingDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ParkingMapper {
    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

   public ParkingDTO parkingDTO(Parking parking){
       return MODEL_MAPPER.map(parking,ParkingDTO.class);
   }
    public List<ParkingDTO> toParkingDTOToList(List<Parking> parkingList) {
       return null;
    }
}
