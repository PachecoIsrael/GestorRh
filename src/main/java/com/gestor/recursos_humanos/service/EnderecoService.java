package com.gestor.recursos_humanos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestor.recursos_humanos.api.dto.PessoaDto;
import com.gestor.recursos_humanos.api.model.pessoa.Endereco;
import com.gestor.recursos_humanos.api.model.pessoa.Logradouro;
import com.gestor.recursos_humanos.api.model.pessoa.Pessoa;
import com.gestor.recursos_humanos.api.repository.EnderecoRepository;

@Service
public class EnderecoService {
    
    @Autowired
    private EnderecoRepository enderecoRepository;

    @Transactional
    public Endereco salvarEndereco(PessoaDto dto, Logradouro logradouro, Pessoa pessoa) {
        Endereco endereco = new Endereco();
        
		endereco.setAtual(true);
		endereco.setNumero(dto.getNumero());
		endereco.setReferencia(dto.getReferencia());
		endereco.setComplemento(dto.getComplemento());
		endereco.setPessoa(pessoa);
		endereco.setLogradouro(logradouro);
    	return enderecoRepository.save(endereco);
    }
}
