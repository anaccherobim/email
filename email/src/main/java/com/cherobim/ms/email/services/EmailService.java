package com.cherobim.ms.email.services;

import java.time.LocalDateTime;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.cherobim.ms.email.enums.StatusEmail;
import com.cherobim.ms.email.model.EmailModel;
import com.cherobim.ms.email.repositories.EmailRepository;

@Service
public class EmailService {
	
	@Autowired(required = false)
	EmailRepository emailRepository;
	
	@Autowired
	private JavaMailSender emailSender;


	public EmailModel sendEmail(EmailModel emailModel) {
		
		emailModel.setSendDateEmail(LocalDateTime.now()); 
		System.err.print("INICIA O SALVAR DO EMAIL ");
		
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			
			message.setFrom(emailModel.getEmailFrom()); 
			message.setTo(emailModel.getEmailTo());
			message.setSubject(emailModel.getSubject());
			message.setText(emailModel.getText());
			emailSender.send(message);
			
			System.err.printf("Message", message);
			
			emailModel.setStatusEmail(StatusEmail.SENT);
			
		} catch (Exception e) {
			System.err.printf("ERRO - ",e);
			emailModel.setStatusEmail(StatusEmail.ERROR);
			
		} finally {
			System.err.printf("FINALIZOU ENVIO DE EMAIL");
			return emailRepository.save(emailModel);
			
		}
		
	}
	

}
