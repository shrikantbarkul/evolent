package com.evolent.contact.service.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TraceableError {

	private String errorCode;
	private String errorDescription;
	private String exceptionType;
	private String exceptionMessage;
	
}
