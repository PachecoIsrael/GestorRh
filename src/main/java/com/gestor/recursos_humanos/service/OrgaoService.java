package com.gestor.recursos_humanos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestor.recursos_humanos.api.model.Orgao;
import com.gestor.recursos_humanos.api.repository.OrgaoRepository;

@Service
public class OrgaoService {
    @Autowired
    private OrgaoRepository orgaoRepository;

    public List<Orgao> buscarOrgao(){
        return orgaoRepository.findAll();
    }
    
}
