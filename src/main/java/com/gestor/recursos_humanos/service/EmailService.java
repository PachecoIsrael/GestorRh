package com.gestor.recursos_humanos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestor.recursos_humanos.api.dto.PessoaDto;
import com.gestor.recursos_humanos.api.model.listas.Email;
import com.gestor.recursos_humanos.api.model.pessoa.Pessoa;
import com.gestor.recursos_humanos.api.repository.EmailRepository;

@Service
public class EmailService {
    
    @Autowired
    private EmailRepository emailRepository;

    @Transactional
	public Email salvarEmail(PessoaDto dto, Pessoa pessoa) {
		Email email = new Email();
		email.setEmail(dto.getEmail());
		email.setAtual(true);
		email.setPessoa(pessoa);
		return emailRepository.save(email);
	}
}
