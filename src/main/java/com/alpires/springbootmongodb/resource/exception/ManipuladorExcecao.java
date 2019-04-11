package com.alpires.springbootmongodb.resource.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.alpires.springbootmongodb.service.exeption.ObjectNotFoundException;

@ControllerAdvice  //trata possiveis erros
public class ManipuladorExcecao {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objetoNaoEncontrado(ObjectNotFoundException e, HttpServletRequest request){
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(System.currentTimeMillis(), 
				                        status.value(), 
				                        "Não Encontrado", 
				                        e.getMessage(), 
				                        request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

}
