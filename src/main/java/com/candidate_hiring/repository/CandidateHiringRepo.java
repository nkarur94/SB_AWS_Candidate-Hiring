package com.candidate_hiring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.candidate_hiring.entity.CandidateHiringDetailsEntity;

public interface CandidateHiringRepo extends JpaRepository<CandidateHiringDetailsEntity, Long> {

	
	@Query(value="select * from candidate_hiring where status = :status",nativeQuery = true)
	List<CandidateHiringDetailsEntity> findByStatusCandidateHiringDetailsEntities(String status);
	
	@Query(value="select count(*) from candidate_hiring where status= :status",nativeQuery = true)
	int noOfCountForStatusPresent(String status);	
}
