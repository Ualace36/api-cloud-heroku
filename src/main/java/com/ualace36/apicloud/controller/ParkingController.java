package com.ualace36.apicloud.controller;

import com.ualace36.apicloud.model.Parking;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/parking")
public class ParkingController {
     @GetMapping
    public List<Parking> findAll(){
        var parking = new Parking();
        parking.setColor("preto");
        parking.setLicense("NZS 2578");
        parking.setState("BA");
        parking.setModel("Passione");
        return Arrays.asList(parking);
    }

}
