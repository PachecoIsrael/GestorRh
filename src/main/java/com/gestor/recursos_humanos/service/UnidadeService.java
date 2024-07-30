package com.gestor.recursos_humanos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestor.recursos_humanos.api.model.Unidade;
import com.gestor.recursos_humanos.api.repository.UnidadeRepository;

@Service
public class UnidadeService {
    
    @Autowired
    private UnidadeRepository unidadeRepository;

    public Unidade findByIdUnidade(Integer idUnidade){
        return unidadeRepository.findByIdUnidade(idUnidade);
    }

    public Boolean cadastraUnidade(Unidade unidade){
        // Integer unidadeRegistrada = unidadeRepository.countBySigla(unidade.getSigla());
        Boolean registrado = false;
        // if(unidadeRegistrada < 1){
            unidadeRepository.save(unidade);
            registrado = true;
        // }
        return registrado;
    }

    public Boolean editUnidade(Unidade unidade){
        Integer unidadeRegistrada = unidadeRepository.countByIdUnidade(unidade.getIdUnidade());
        Boolean registrado = false;
        if(unidadeRegistrada == 1){
            unidadeRepository.save(unidade);
            registrado = true;
        }
        return registrado;
    }
}
