package com.evolent.contact.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	@ExceptionHandler(value = ContactException.class)
	public ResponseEntity<TraceableError> handleContactException(ContactException exception){
		log.error("Handling Contact Exception");
		if(null == exception.getStatusCode()) {
			exception.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		TraceableError error = TraceableError.builder()
				.errorCode(exception.getStatusCode().toString())
				.errorDescription(exception.getCause().toString())
				.exceptionType(exception.getClass().getSimpleName())
				.exceptionMessage(exception.getMessage())
				.build();
		
		return new ResponseEntity<>(error, exception.getStatusCode());
	}
}
