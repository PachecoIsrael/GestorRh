package com.gestor.recursos_humanos.api.model.pessoa;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gestor.recursos_humanos.api.model.listas.Cidade;
import com.gestor.recursos_humanos.api.model.listas.Deficiencia;
import com.gestor.recursos_humanos.api.model.listas.Email;
import com.gestor.recursos_humanos.api.model.listas.Escolaridade;
import com.gestor.recursos_humanos.api.model.listas.Estado;
import com.gestor.recursos_humanos.api.model.listas.EstadoCivil;
import com.gestor.recursos_humanos.api.model.listas.Etnia;
import com.gestor.recursos_humanos.api.model.listas.OrientacaoSexual;
import com.gestor.recursos_humanos.api.model.listas.Pais;
import com.gestor.recursos_humanos.api.model.listas.Sexo;
import com.gestor.recursos_humanos.api.model.listas.Telefone;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPessoa;

    @NotNull
    @Size(max=255)
    private String nome;

    @NotNull
    @CPF
    private String cpf;

    @NotNull
    @Size(max=255)
    private String nomeMae;

    @Size(max=255)
    private String nomePai;

    @NotNull
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "fk_sexo")
    private Sexo sexo;

    @Size(max=50)
    private String nomeSocial;

    @NotNull
    @JoinColumn(name = "fk_orientacao_sexual")
    @ManyToOne
    private OrientacaoSexual orientacaoSexual;

    @NotNull
    @JoinColumn(name = "fk_deficiencia")
    @ManyToOne
    private Deficiencia deficiencia;

    @NotNull
    @JoinColumn(name = "fk_etnia")
    @ManyToOne
    private Etnia etnia;

    @NotNull
    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_pais")
    private Pais pais;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "fk_estado")
    private Estado estadoNaturalidade;

    @ManyToOne
    @JoinColumn(name = "fk_cidade")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private Cidade cidadeNaturalidade;

    @JsonIgnoreProperties
    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Email> email;

    @JsonIgnoreProperties
    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Telefone> telefone;
    
    @JoinColumn(name = "fk_estado_civil")
    @ManyToOne
    private EstadoCivil estadoCivil;

    @JoinColumn(name = "fk_escolaridade")
    @ManyToOne
    private Escolaridade escolaridade;
}
