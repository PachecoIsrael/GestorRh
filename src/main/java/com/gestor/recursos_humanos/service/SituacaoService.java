package com.gestor.recursos_humanos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestor.recursos_humanos.api.model.Situacao;
import com.gestor.recursos_humanos.api.repository.SituacaoRepository;

@Service
public class SituacaoService {
    @Autowired
    private SituacaoRepository situacaoRepository;

    public List<Situacao> buscarSituacao(){
        return situacaoRepository.findAll();
    }

    public Boolean editarSituacao(Situacao situacao){
        Boolean editado = false;
        Situacao sit = situacaoRepository.findByIdSituacao(situacao.getIdSituacao());
        if(sit!=null){
            situacaoRepository.save(situacao);
            editado = true;
        }
        return editado;
    }
    
    public Boolean cadastrarSituacao(Situacao situacao){
        Boolean editado = false;
        situacaoRepository.save(situacao);
        editado = true;
        return editado;
    }
    
}
