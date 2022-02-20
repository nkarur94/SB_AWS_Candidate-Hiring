package com.candidate_hiring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.candidate_hiring.DTO.CandidateHiringDetailsDTO;
import com.candidate_hiring.DTO.ResponseDTO;
import com.candidate_hiring.service.ICandidateHiringService;

@RestController
@RequestMapping("/candidatehiring")
public class CandidateHiringController {
	
	@Autowired
	ICandidateHiringService iCandidateService;
	
	@PostMapping("/add")
	public ResponseEntity<ResponseDTO> addCandidate(@RequestHeader String token, @Valid @RequestBody CandidateHiringDetailsDTO detailsDTO){
		ResponseDTO response = iCandidateService.addDetailsOfCandidate(token, detailsDTO);
		return new ResponseEntity<ResponseDTO>(response,HttpStatus.OK);
		
	}
	
	@PutMapping("/update/{CHId}")
	public ResponseEntity<ResponseDTO> updateCandidateH(@RequestHeader String token, @PathVariable Long CHId, @Valid @RequestBody CandidateHiringDetailsDTO detailsDTO){
		ResponseDTO response = iCandidateService.updateDetailsOfCandidateHiring(token, CHId, detailsDTO);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}
	
	@GetMapping("/view")
	public ResponseEntity<ResponseDTO> view (@RequestHeader String token){
		ResponseDTO response = iCandidateService.viewAllDetails(token);
		return new ResponseEntity<ResponseDTO>(response,HttpStatus.OK);
		
	}
	
	@GetMapping("/viewbyid/{CHId}")
	public ResponseEntity<ResponseDTO> viewById(@RequestHeader String token, @PathVariable Long CHId){
		ResponseDTO response = iCandidateService.viewCandidateById(token, CHId);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{CHId}")
	public ResponseEntity<ResponseDTO> deleteId(@RequestHeader String token, @PathVariable Long CHId){
		ResponseDTO response = iCandidateService.deleteCandidate(token, CHId);
		
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);

	}
	
	@PutMapping("/updateonboarding/{CHId}")
	public ResponseEntity<ResponseDTO> updateOnborading(@RequestHeader String token,@PathVariable Long CHId, @RequestParam(value="status") String onboardingStatus){
		ResponseDTO response = iCandidateService.updateOnboardingStatus(token, CHId, onboardingStatus);
		return new ResponseEntity<ResponseDTO>(response,HttpStatus.OK);
	}
	
	@GetMapping("/getallstatusactive/{status}")
	public ResponseEntity<ResponseDTO> getAllStatusActive(@RequestHeader String token,@PathVariable String status){
		ResponseDTO response = iCandidateService.getCandidateStatusAsActive(token, status);
		return new  ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}
	
	@GetMapping("/getcount/{status}")
	public ResponseEntity<ResponseDTO> getCount(@RequestHeader String token, @PathVariable String status){
		ResponseDTO response = iCandidateService.getCandidateStatusCount(token, status);
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
		
	}
	
	

	
	

}
