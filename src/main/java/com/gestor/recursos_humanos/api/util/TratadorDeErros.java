package com.gestor.recursos_humanos.api.util;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.gestor.recursos_humanos.api.model.exceptions.EnderecoNotFoundException;
import com.gestor.recursos_humanos.api.model.exceptions.PessoaAlreadyRegisteredException;
import com.gestor.recursos_humanos.api.model.exceptions.PessoaNotFound;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> tratarErro400(MethodArgumentNotValidException ex){
        var erros = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(erros.stream().map(DadosErroValidacao::new).toList());
    }
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<?> tratarErro404(NoSuchElementException ex){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(PessoaAlreadyRegisteredException.class)
    public ResponseEntity<?> tratarError409(PessoaAlreadyRegisteredException ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new DadosErroStatus(HttpStatus.CONFLICT.toString(), "Pessoa já consta na Base de dados"));
    }

    @ExceptionHandler(PessoaNotFound.class)
    public ResponseEntity<?> PessoaNãoEncontrada(PessoaNotFound ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new DadosErroStatus(HttpStatus.NOT_FOUND.toString(), ex.getMessage()));
    }

    @ExceptionHandler(EnderecoNotFoundException.class)
    public ResponseEntity<?> tratarError409(EnderecoNotFoundException ex){
    	return ResponseEntity.status(HttpStatus.CONFLICT).body(new DadosErroStatus(HttpStatus.CONFLICT.toString(), ex.getMessage())); 
    }
    
    private record DadosErroValidacao(String campo, String message){
        public DadosErroValidacao(FieldError erro){
            this(erro.getField(), erro.getDefaultMessage());
        }
    }

    private record DadosErroStatus(String status, String message){}

}
