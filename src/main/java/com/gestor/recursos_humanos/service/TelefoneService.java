package com.gestor.recursos_humanos.service;

import org.springframework.stereotype.Service;

import com.gestor.recursos_humanos.api.dto.PessoaDto;
import com.gestor.recursos_humanos.api.model.listas.Telefone;
import com.gestor.recursos_humanos.api.model.pessoa.Pessoa;
import com.gestor.recursos_humanos.api.repository.TelefoneRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TelefoneService {
    
    private final TelefoneRepository telefoneRepository;
    public Telefone salvarTelefone(PessoaDto pessoaDto, Pessoa pessoa){
        Telefone telefone = new Telefone();
        telefone.setAtual(true);
        telefone.setTelefone(pessoaDto.getTelefone());
        telefone.setPessoa(pessoa);
        return telefoneRepository.save(telefone);
    }
}
