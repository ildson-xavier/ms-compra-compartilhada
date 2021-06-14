package br.com.compraemgrupo.cogrupo.rest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundCategoriaException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public NotFoundCategoriaException(String message) {
		super(message);
	}
}
