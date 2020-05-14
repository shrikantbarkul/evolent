package com.evolent.contact.service.exception;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(MockitoExtension.class)
class GlobalExceptionHandlerTest {

	@InjectMocks
	GlobalExceptionHandler globalExceptionHandler;

	@Test
	void testHandleContactException() {
		try {
			throw new ContactException(HttpStatus.INTERNAL_SERVER_ERROR, "New Exception");
		} catch (ContactException ex) {
			ResponseEntity<TraceableError> error = globalExceptionHandler.handleContactException(ex);
			assertNotNull(error);
			log.info("Error {}", error);
		}
	}

	@Test
	void testHandleContactExceptionwithMessage() {
		try {
			throw new ContactException("New Exception");
		} catch (ContactException ex) {
			ResponseEntity<TraceableError> error = globalExceptionHandler.handleContactException(ex);
			assertNotNull(error);
			log.info("Error {}", error);
		}
	}

	@Test
	void testHandleContactExceptionAllarg() {
		try {
			String[] args = {"ARG1", "ARG2"};
			throw new ContactException(HttpStatus.INTERNAL_SERVER_ERROR,"New Exception",
					"testHandleContactExceptionAllarg", args); 
		} catch (ContactException ex) {
			ResponseEntity<TraceableError> error = globalExceptionHandler.handleContactException(ex);
			assertNotNull(error);
			log.info("Error {}", error);
		}		
	}
}
