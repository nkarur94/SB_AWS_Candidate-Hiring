package com.candidate_hiring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
}
