package com.candidate_hiring.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.candidate_hiring.DTO.CandidateHiringDetailsDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name="candidate_hiring")
public class CandidateHiringDetailsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long CHId;
	
	private String firstName;
	private String middelName;
	private String lastName;
	private String eMail;
	private String mobileNo;
	private String hiredCity;
	private LocalDate hiredDate;
	private String degree;
	private String hiredlab;
	private String attitudeRemark;
	private String communicationRemark;
	private String knowledgeRemark;
	private String onboardStatus;
	private String status;
	private Long creatorUser;
	private LocalDate joindate;
	private String location;
	private double aggrPer;
	private String currentPinCode;
	private String permanentPinCode;
	
	public CandidateHiringDetailsEntity(CandidateHiringDetailsDTO detailsDto) {
		super();
		this.firstName = detailsDto.firstName;
		this.middelName = detailsDto.middelName;
		this.lastName = detailsDto.lastName;
		this.eMail =detailsDto.eMail;
		this.mobileNo = detailsDto.mobileNo;
		this.hiredCity = detailsDto.hiredCity;
		this.hiredDate = detailsDto.hiredDate;
		this.degree = detailsDto.degree;
		this.hiredlab = detailsDto.hiredlab;
		this.attitudeRemark = detailsDto.attitudeRemark;
		this.communicationRemark = detailsDto.communicationRemark;
		this.knowledgeRemark = detailsDto.knowledgeRemark;
		this.onboardStatus = detailsDto.onboardStatus;
		this.status = detailsDto.status;
		this.joindate = detailsDto.joindate;
		this.location = detailsDto.location;
		this.aggrPer = detailsDto.aggrPer;
		this.currentPinCode = detailsDto.currentPinCode;
		this.permanentPinCode = detailsDto.permanentPinCode;
	}
	
	
	

}
