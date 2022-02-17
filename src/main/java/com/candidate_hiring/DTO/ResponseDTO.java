package com.candidate_hiring.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseDTO {	
	
	
	public String message;
	public Object data;
	
	public ResponseDTO(String message) {
		super();
		this.message = message;
	}
	
 }
