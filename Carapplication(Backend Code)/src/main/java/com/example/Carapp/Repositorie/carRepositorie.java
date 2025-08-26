package com.example.Carapp.Repositorie;

import com.example.Carapp.Model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface carRepositorie extends JpaRepository<Car, Long> {
}
