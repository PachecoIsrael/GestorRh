package com.gestor.recursos_humanos.api.model.exceptions;

public class PessoaNotFound extends RuntimeException{

    private static final long serialVersionUID = 1L;

	public PessoaNotFound(String exception){
        super(exception);
    }
}
