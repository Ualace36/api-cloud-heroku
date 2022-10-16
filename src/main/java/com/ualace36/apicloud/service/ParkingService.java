package com.ualace36.apicloud.service;

import com.ualace36.apicloud.model.Parking;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.*;
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
}