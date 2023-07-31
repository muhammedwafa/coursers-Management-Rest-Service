package com.kfh.coursers.Management.Rest.Service.api.exception;


import com.kfh.coursers.Management.Rest.Service.api.payloads.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceBnotFoundExceptionHAndler(ResourceNotFoundException ex){
		String message = ex.getMessage();
		ApiResponse apiResponce = new ApiResponse(message,false);
		return new ResponseEntity<ApiResponse> (apiResponce , HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> methodArgumentNotValidException(MethodArgumentNotValidException mae){
             		
		Map<String, String> res = new HashMap<>();
		mae.getBindingResult().getAllErrors().forEach((error)->{
			
			String fieldName = ((FieldError)error).getField();
			String message = error.getDefaultMessage();
			res.put(fieldName, message);
		});
		
		return new ResponseEntity<Map<String,String>>(res,HttpStatus.BAD_REQUEST);
	}
}
