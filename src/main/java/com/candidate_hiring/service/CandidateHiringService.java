package com.candidate_hiring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.candidate_hiring.DTO.CandidateHiringDetailsDTO;
import com.candidate_hiring.DTO.ResponseDTO;
import com.candidate_hiring.entity.CandidateHiringDetailsEntity;
import com.candidate_hiring.repository.CandidateHiringRepo;

@Service
public class CandidateHiringService implements ICandidateHiringService {
	
	@Autowired
	CandidateHiringRepo repoForHire;

	@Override
	public ResponseDTO addDetailsOfCandidate(CandidateHiringDetailsDTO detailsDTO) {
		// TODO Auto-generated method stub
		CandidateHiringDetailsEntity entity = new CandidateHiringDetailsEntity(detailsDTO);
		repoForHire.save(entity);
		ResponseDTO response = new ResponseDTO ("added details of candidate for hiring",entity);
		
		return response;
	}

}
