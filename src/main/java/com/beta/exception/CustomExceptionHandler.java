// license/copyright header
package com.beta.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/** Generic Exception handler
 * 
 * @author Sumit Khedkar.
 *
 */
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { IllegalArgumentException.class})
	public ResponseEntity<String> handleInvalidInputCase() {
		
		return new ResponseEntity<>("{\"errorMessage\" : \"Invalid inputs received.\"}", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = { Exception.class})
	public ResponseEntity<String> handleUnknownCase() {
		
		return new ResponseEntity<>("Exception occurred while processing request.", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
