package com.candidate_hiring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.candidate_hiring.entity.CandidateHiringDetailsEntity;

public interface CandidateHiringRepo extends JpaRepository<CandidateHiringDetailsEntity, Long> {

}
