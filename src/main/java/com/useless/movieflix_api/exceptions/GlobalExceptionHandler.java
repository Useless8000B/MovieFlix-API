package com.useless.movieflix_api.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.useless.movieflix_api.dto.ErrorResponse;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleGenericException(Exception e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

		ErrorResponse error = new ErrorResponse(
			LocalDateTime.now(),
			status.value(),
			e.getMessage(),
			status.getReasonPhrase(),
			request.getRequestURI()
		);

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
	}

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorResponse> handleNotFound(NotFoundException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;

		ErrorResponse error = new ErrorResponse(
			LocalDateTime.now(),
			status.value(),
			e.getMessage(),
			status.getReasonPhrase(),
			request.getRequestURI()
		);

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
}