package com.cherobim.ms.email.dto;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class EmailDto {

	@NotBlank
	private String ownerRef;
	
	@NotBlank
	@Email
	private String emailFrom;
	
	@NotBlank
	@Email
	@Column(name = "emailTo")
	private String emailTo;
	
	@NotBlank
	private String subject;
	
	@NotBlank
	private String text;
}
