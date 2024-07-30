package com.gestor.recursos_humanos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestor.recursos_humanos.api.model.Contrato;
import com.gestor.recursos_humanos.api.repository.ContratoRepository;

@Service
public class ContratoService {
    @Autowired
    private ContratoRepository contratoRepository;

    public List<Contrato> buscarContrato() {
        return contratoRepository.findAll();
    }
    
}
