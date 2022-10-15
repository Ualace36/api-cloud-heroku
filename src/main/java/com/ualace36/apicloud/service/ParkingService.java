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
        var parking = new Parking(id, "OZS 2548", "BA", "207", "PRETO");
        parkingMap.put(id, parking);
    }

    public List<Parking> findAll(){
        return parkingMap.values().stream().collect(Collectors.toList());
    }
    private static String getUUID() {
     return UUID.randomUUID().toString().replace("-", "");
    }
}