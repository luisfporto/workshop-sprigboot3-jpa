package com.lp.course.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.lp.course.services.exceptions.DatabaseException;
import com.lp.course.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
	/*
	 * ResponseEntity retrieves the complete Http response, as body status code and
	 * headers According to most part of the videos, this method will be used to get
	 * the response
	 */
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandartError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandartError err = new StandartError(Instant.now(), status.value(), error, e.getMessage(),
				request.getRequestURI());
		/*
		 * O status.value() se faz necessário pois a variável "status" não tem um
		 * construtor que remeta diretamente a ela, sendo assim, é necessário buscar
		 * dentro do método
		 */
		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandartError> database(DatabaseException e, HttpServletRequest request) {
		String error = "Database error";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandartError err = new StandartError(Instant.now(), status.value(), error, e.getMessage(),
				request.getRequestURI());
		/*
		 * O status.value() se faz necessário pois a variável "status" não tem um
		 * construtor que remeta diretamente a ela, sendo assim, é necessário buscar
		 * dentro do método
		 */
		return ResponseEntity.status(status).body(err);
	}
}
