package com.gestor.recursos_humanos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestor.recursos_humanos.api.model.Classe;
import com.gestor.recursos_humanos.api.repository.ClasseRepository;

@Service
public class ClasseService {
    @Autowired
    private ClasseRepository classeRepository;

    public List<Classe> buscarClasse(){
        return classeRepository.findAll();
    }
    
}
