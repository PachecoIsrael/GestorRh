package com.gestor.recursos_humanos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestor.recursos_humanos.api.model.CargoExercicio;
import com.gestor.recursos_humanos.api.repository.CargoExercicioRepository;

@Service
public class CargoExercicioService {
    @Autowired
    private CargoExercicioRepository cargoExercicioRepository;

    public List<CargoExercicio> buscarCargoExercicio(){
        return cargoExercicioRepository.findAll();
    }
    
}
