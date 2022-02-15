package com.candidate_hiring.service;

import com.candidate_hiring.DTO.CandidateHiringDetailsDTO;
import com.candidate_hiring.DTO.ResponseDTO;

public interface ICandidateHiringService {
	
	public ResponseDTO addDetailsOfCandidate(CandidateHiringDetailsDTO detailsDTO);

}
