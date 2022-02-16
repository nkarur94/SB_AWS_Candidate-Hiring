package com.candidate_hiring.DTO;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CandidateHiringDetailsDTO {
	
	public String firstName;
	public String middelName;
	public String lastName;
	public String eMail;
	public String mobileNo;
	public String hiredCity;
	
	@JsonFormat(pattern = "dd MM yyyy")
	public LocalDate hiredDate;
	public String degree;
	public String hiredlab;
	public String attitudeRemark;
	public String communicationRemark;
	public String knowledgeRemark;
	
	public String onboardStatus;
	public String status;

	@JsonFormat(pattern = "dd MM yyyy")
	public LocalDate joindate;
	public String location;
	public double aggrPer;
	public int currentPinCode;
	public int permanentPinCode;

}
