package com.gestor.recursos_humanos.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestor.recursos_humanos.api.dto.PessoaDto;
import com.gestor.recursos_humanos.api.model.pessoa.Pessoa;
import com.gestor.recursos_humanos.service.PessoaService;

@RestController
@RequestMapping("/api/v1/pessoa")
public class PessoaControler {
    
    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public List<Pessoa> listar(){
        return pessoaService.listarPessoas();
    }

    @PostMapping
	public ResponseEntity<?> salvarCadastroPessoa(@RequestBody PessoaDto pessoaDto){
		Pessoa pessoa = pessoaService.criarNovaPessoa(pessoaDto);
		if (pessoa != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body("cadastro efetuado com sucesso!");
		}
		return ResponseEntity.status(HttpStatus.CONFLICT).body("não foi possivel efetuar o cadastro no momento!");
	}
}
