package com.gestor.recursos_humanos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestor.recursos_humanos.api.model.Ensino;
import com.gestor.recursos_humanos.api.repository.EnsinoRepository;

@Service
public class EnsinoService {
    @Autowired
    private EnsinoRepository ensinoRepository;

    public List<Ensino> buscarEnsino(){
        return ensinoRepository.findAll();
    }
}
