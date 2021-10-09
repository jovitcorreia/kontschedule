package br.com.kontulari.kontschedule.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AtividadeNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public AtividadeNotFoundException(Long id) {
		super("Atividade not found with ID " + id);
	}
}
