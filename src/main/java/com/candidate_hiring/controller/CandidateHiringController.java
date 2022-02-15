package com.candidate_hiring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.candidate_hiring.DTO.CandidateHiringDetailsDTO;
import com.candidate_hiring.DTO.ResponseDTO;

@RestController
@RequestMapping("/candidatehiring")
public class CandidateHiringController {
	
	@PostMapping("/add")
	public ResponseEntity<ResponseDTO> addCandidate(@RequestBody CandidateHiringDetailsDTO detailsDTO){
		return null;
		
	}
	

}
