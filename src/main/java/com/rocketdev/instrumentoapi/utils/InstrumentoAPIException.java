package com.rocketdev.instrumentoapi.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 * Classe que encapsula as exceções do backend
 * 
 * @author Rafael Marcelo
 *
 */
public class InstrumentoAPIException extends ResponseStatusException {

	private static final long serialVersionUID = -891646592411795131L;

	public InstrumentoAPIException(String mensagem) {
		super(HttpStatus.INTERNAL_SERVER_ERROR, mensagem, null);
	}
}
