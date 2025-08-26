package com.example.Carapp.Service;

import com.example.Carapp.Model.Car;
import com.example.Carapp.Repositorie.carRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private carRepositorie carRepository;

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    public Optional<Car> getCarById(Long id) {
        return carRepository.findById(id);
    }

    public Car updateCar(Long id, Car updatedCar) {
        return carRepository.findById(id).map(existingCar -> {
            existingCar.setName(updatedCar.getName());
            existingCar.setBrand(updatedCar.getBrand());
            existingCar.setFuel(updatedCar.getFuel());
            existingCar.setSeats(updatedCar.getSeats());
            existingCar.setRentPerDay(updatedCar.getRentPerDay());
            existingCar.setImage(updatedCar.getImage());
            return carRepository.save(existingCar);
        }).orElse(null);
    }
}
