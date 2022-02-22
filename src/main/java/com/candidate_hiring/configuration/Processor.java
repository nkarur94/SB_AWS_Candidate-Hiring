package com.candidate_hiring.configuration;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.candidate_hiring.entity.CandidateHiringDetailsEntity;

@Component
public class Processor implements ItemProcessor<CandidateHiringDetailsEntity, CandidateHiringDetailsEntity> {

	@Override
	public CandidateHiringDetailsEntity process(CandidateHiringDetailsEntity candidateProcess) throws Exception {
		// TODO Auto-generated method stub
		return candidateProcess;
	}

}
