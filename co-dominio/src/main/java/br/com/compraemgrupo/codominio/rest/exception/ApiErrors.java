package br.com.compraemgrupo.codominio.rest.exception;

import java.util.Arrays;
import java.util.List;

public class ApiErrors {

	private List<String> errors;
	
	public ApiErrors(List<String> errors) {
		this.setErrors(errors);
	}
	
	public ApiErrors(String message) {
		this.setErrors(Arrays.asList(message));
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
}
