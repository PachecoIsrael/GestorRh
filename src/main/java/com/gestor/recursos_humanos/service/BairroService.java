package com.gestor.recursos_humanos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestor.recursos_humanos.api.model.pessoa.Bairro;
import com.gestor.recursos_humanos.api.repository.BairroRepository;

@Service
public class BairroService {
    
    @Autowired
    private BairroRepository bairroRepository;

    public Bairro findByBairroPorIdCidadeNome(Integer idCidade, String descricao) {
		return bairroRepository.findByCidadeIdCidadeAndDescricao(idCidade, descricao);
	}
}
