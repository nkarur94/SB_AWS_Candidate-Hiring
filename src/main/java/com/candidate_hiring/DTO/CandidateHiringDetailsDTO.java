package com.candidate_hiring.DTO;

import java.time.LocalDate;

import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class CandidateHiringDetailsDTO {
	
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "candidate firstname is invalid")
	public String firstName;
	
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "candidate middelname is invalid")
	public String middelName;

	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "candidate lastaname is invalid")
	public String lastName;
	
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",message = "invalid email address")
	public String eMail;
	
	@Pattern(regexp = "^[7-9][0-9]{9}",message="you have entered incorrect mobile no format ")
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
	
	@Pattern(regexp="active|inactive",message="status can only be active or inactive")
	public String status;

	@JsonFormat(pattern = "dd MM yyyy")
	public LocalDate joindate;
	public String location;
	public double aggrPer;
	
	@Pattern(regexp="^[1-9]{1}[0-9]{5}",message="incorrect pincode")
	public String currentPinCode;
	
	@Pattern(regexp="^[1-9]{1}[0-9]{5}",message="incorrect pincode")
	public String permanentPinCode;

}
