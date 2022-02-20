package com.candidate_hiring.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.candidate_hiring.DTO.ResponseDTO;

@ControllerAdvice
public class CandidateHiringExceptionHandler {

	@ExceptionHandler(CandidateHiringCustomException.class)
	public ResponseEntity<ResponseDTO> handlingCandidatehiringCustomException(CandidateHiringCustomException exception){
		ResponseDTO response = new ResponseDTO("error while running API",exception.getMessage());
		return new ResponseEntity<ResponseDTO>(response,HttpStatus.OK);
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDTO> handleMethodNotValidException(MethodArgumentNotValidException exception){
		List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
		List<String> errorMessage = errorList.stream().map(objerr -> objerr.getDefaultMessage())
				.collect(Collectors.toList());
		ResponseDTO responseDTO = new ResponseDTO("Exception while processing REST request", errorMessage);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
	}
}
