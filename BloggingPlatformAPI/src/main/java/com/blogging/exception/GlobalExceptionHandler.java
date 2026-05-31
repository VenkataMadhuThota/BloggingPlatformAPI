package com.blogging.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.blogging.dto.ExceptionDTO;
import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler 
{
	private ExceptionDTO buildDto(HttpStatus status, String message, HttpServletRequest request) 
	{
	    ExceptionDTO dto = new ExceptionDTO();
	    dto.setTimestamp(LocalDateTime.now());
	    dto.setStatus(status.value());
	    //dto.setError(status.name());
	    dto.setError(status.getReasonPhrase());
	    dto.setMessage(message);
	    dto.setPath(request.getRequestURI());
	    return dto;
	}
	@ExceptionHandler(BlogNotFoundException.class)
	public ResponseEntity<ExceptionDTO> handleBlogNotFoundException(BlogNotFoundException ex,HttpServletRequest request)
	{
		 return new ResponseEntity<>(buildDto(HttpStatus.NOT_FOUND, ex.getMessage(), request), HttpStatus.NOT_FOUND);
	}
	 @ExceptionHandler(DuplicateBlogTitleException.class)
	  public ResponseEntity<ExceptionDTO> handleDuplicateBlogTitle(DuplicateBlogTitleException ex, HttpServletRequest request) 
	 {
	        return new ResponseEntity<>(buildDto(HttpStatus.CONFLICT, ex.getMessage(), request), HttpStatus.CONFLICT);
	 }
	 @ExceptionHandler(MethodArgumentNotValidException.class)
	 public ResponseEntity<ExceptionDTO> handleValidationException(MethodArgumentNotValidException ex, HttpServletRequest request) 
	 {
	     String message = ex.getBindingResult().getFieldError().getDefaultMessage();
	     return new ResponseEntity<>(buildDto(HttpStatus.BAD_REQUEST, message, request), HttpStatus.BAD_REQUEST);
	 }
	 @ExceptionHandler(Exception.class)
	  public ResponseEntity<ExceptionDTO> handleGenericException(Exception ex, HttpServletRequest request) 
	 {
	        return new ResponseEntity<>(buildDto(HttpStatus.INTERNAL_SERVER_ERROR, "An unexpected error occurred.", request),HttpStatus.INTERNAL_SERVER_ERROR);
	 }

}
