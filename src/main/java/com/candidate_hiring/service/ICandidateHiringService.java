package com.candidate_hiring.service;

import com.candidate_hiring.DTO.CandidateHiringDetailsDTO;
import com.candidate_hiring.DTO.ResponseDTO;

public interface ICandidateHiringService {
	
	public ResponseDTO addDetailsOfCandidate(String token,CandidateHiringDetailsDTO detailsDTO);
	public ResponseDTO updateDetailsOfCandidateHiring(String token, Long CHId, CandidateHiringDetailsDTO detailsDTO);
	
	public ResponseDTO viewAllDetails(String token);
	public  ResponseDTO viewCandidateById(String token, Long CHId);
	
	public ResponseDTO deleteCandidate(String token, Long CHId);
	
	public ResponseDTO updateOnboardingStatus(String token, Long CHId, String onboardingStatus);
}
