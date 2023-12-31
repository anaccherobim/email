package com.cherobim.ms.email.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cherobim.ms.email.enums.StatusEmail;

import lombok.Data;

@Data  //com o import lombok nao precisa get e set
@Entity
@Table(name = "TB_EMAIL")
public class EmailModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long emailId;
	private String ownerRef;
	private String emailFrom;
	private String emailTo;
	private String subject;
	
	@Column(columnDefinition = "TEXT") //Propriedade onde o campo string nao contem um limite. 
	private String text;
	private LocalDateTime sendDateEmail;
	private StatusEmail statusEmail;



}
