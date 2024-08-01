package com.gestor.recursos_humanos.api.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gestor.recursos_humanos.api.model.listas.Cidade;
import com.gestor.recursos_humanos.api.model.listas.Deficiencia;
import com.gestor.recursos_humanos.api.model.listas.Escolaridade;
import com.gestor.recursos_humanos.api.model.listas.Estado;
import com.gestor.recursos_humanos.api.model.listas.EstadoCivil;
import com.gestor.recursos_humanos.api.model.listas.IdentidadeGenero;
import com.gestor.recursos_humanos.api.model.listas.OrientacaoSexual;
import com.gestor.recursos_humanos.api.model.listas.Pais;
import com.gestor.recursos_humanos.api.model.listas.Sexo;
import com.gestor.recursos_humanos.api.model.pessoa.Bairro;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaDto {
    
    @NotBlank
	@NotNull
	@Size(max=255)
	private String nome;

	private String cpf;

	@NotNull
	@NotBlank
	@Size(max=255)
	private String nomeMae;

	@Size(max=255)
	private String nomePai;

	@Size(max=50)
	private String alcunha;

	@Size(max=255)
	private String nomeSocial;

	@NotNull
	private Sexo sexo;

	@NotNull
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dataNascimento;

	private EstadoCivil estadoCivil;

	@NotNull
	private OrientacaoSexual orientacaoSexual;

	@NotNull
	private Deficiencia deficiencia;
	private Escolaridade escolaridade;

	@NotNull
	private Pais pais;
	@NotNull
	private Estado estadoNaturalidade;
	@NotNull
	private Cidade cidadeNaturalidade;

	@NotNull
	private IdentidadeGenero identidadeGenero;
	private Boolean estrangeiro;

	// logradouro	
	private String cep;
	private Estado estado;
	private Cidade cidade;
	private String logradouro;
	private Bairro bairro;
	
	// endereco
	private String numero;
	private Boolean enderecoAtual;
	private String complemento;
	private String referencia;

	// contato
	private String telefone;
	private Boolean telefoneAtual;
	private String tipoCelular;
	private Boolean tipoWhatsapp;
	private Boolean tipoTelegram;

    // email
	@NotBlank
	@Email
	private String email;
	@NotNull
	private Boolean emailAtual = true;
	private String senha;
	
}
