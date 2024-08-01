package com.gestor.recursos_humanos.api.model.listas;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gestor.recursos_humanos.api.model.pessoa.Pessoa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Email {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_email;

    private String email;

    private Boolean atual = false;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "fk_pessoa")
    private Pessoa pessoa;
}
