package com.ualace36.apicloud.service;

import com.ualace36.apicloud.model.Parking;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ParkingService {

    private static Map<String, Parking> parkingMap = new HashMap<>();

    static {
        var id =getUUID();
        var id1 =getUUID();
        var parking = new Parking(id, "OZS 2548", "BA", "207", "PRETO");
        var parking2 = new Parking(id1, "OZT 2544", "BA", "208", "GRAFITTE");
        parkingMap.put(id, parking);
        parkingMap.put(id1, parking2);
    }

    public List<Parking> findAll(){
        return parkingMap.values().stream().collect(Collectors.toList());
    }
    private static String getUUID() {
     return UUID.randomUUID().toString().replace("-", "");
    }


    public Parking findById(String id) {
        return parkingMap.get(id);
    }

    public Parking create(Parking parkingCreate) {
        String uuid = getUUID();
        parkingCreate.setId(uuid);
        parkingCreate.setEntryDate(LocalDateTime.now());
        parkingMap.put(uuid, parkingCreate);
        return parkingCreate;

    }
}