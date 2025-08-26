package com.example.Carapp.Controller;

import com.example.Carapp.Model.Car;
import com.example.Carapp.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")  // Correct scoped path to prevent mapping conflict
@CrossOrigin(origins = "*")
public class CarController {

    @Autowired
    private CarService carService;

    // GET all cars
    @GetMapping
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    // POST a new car
    @PostMapping
    public Car addCar(@RequestBody Car car) {
        return carService.addCar(car);
    }

    // DELETE a car by ID
    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
    }

    // GET car by ID
    @GetMapping("/{id}")
    public Car getCarById(@PathVariable Long id) {
        return carService.getCarById(id).orElse(null);
    }

    // PUT (Update) car by ID
    @PutMapping("/{id}")
    public Car updateCar(@PathVariable Long id, @RequestBody Car updatedCar) {
        return carService.updateCar(id, updatedCar);
    }
}
