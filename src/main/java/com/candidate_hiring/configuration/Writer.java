package com.candidate_hiring.configuration;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.candidate_hiring.entity.CandidateHiringDetailsEntity;
import com.candidate_hiring.repository.CandidateHiringRepo;

@Component
public class Writer implements ItemWriter<CandidateHiringDetailsEntity>{


	private CandidateHiringRepo candidateRepo;

    @Autowired
    public Writer (CandidateHiringRepo candidateRepo) {
        this.candidateRepo = candidateRepo;
    }
	@Override
	public void write(List<? extends CandidateHiringDetailsEntity> candidate) throws Exception {
		// TODO Auto-generated method stub
		 System.out.println("Data Saved for Users: " + candidate);
	      for (CandidateHiringDetailsEntity candidateEntity : candidate) {
				System.out.println(candidate);
				candidateRepo.save(candidateEntity);
			}
		
	}

}
