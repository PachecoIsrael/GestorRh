package com.gestor.recursos_humanos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestor.recursos_humanos.api.model.Atividade;
import com.gestor.recursos_humanos.api.repository.AtividadeRepository;

@Service
public class AtividadeService {
    @Autowired
    private AtividadeRepository atividadeRepository;

    public List<Atividade> buscarAtividade(){
        return atividadeRepository.findAll();
    }
}
