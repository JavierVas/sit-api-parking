package com.parking.apiparking.controller;

import com.parking.apiparking.entities.Car;
import com.parking.apiparking.services.ParkingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/parking") //parking => URL
public class ParkingController {

    //Inyeyccion de Dependencias => instancias;

    private final ParkingService parkingService;

    public ParkingController(ParkingService parkingService){
        this.parkingService = parkingService;
    }

    //GET: http://dominio/parking/cars => obtener la lista de carros
//    @GetMapping("/cars")
//    public List<Car> getAllCars(){
//        return this.parkingService.getAllCars();
//    }

    @GetMapping("/cars")
    public ResponseEntity<List<Car>> getAllCars(){
//        return ResponseEntity<List<Car>>(this.parkingService.getAllCars(), HttpStatus.OK);
        return ResponseEntity.ok(this.parkingService.getAllCars());
    }

    //POST: http://dominio/parking/cars => obtener la lista de carros
    @PostMapping("/cars")
    public ResponseEntity<Car> addCar(Car car){
        this.parkingService.addCar(car);
        return new ResponseEntity<>(car, HttpStatus.CREATED);
    }
}
