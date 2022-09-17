package com.david.ProyectoSioca.serviceimp;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

@Component
public class SendEmail {

	@Autowired
	private JavaMailSender sender;
	
	public void sendMail(String to,String subject,String body,String URLpdf) {
		MimeMessage message = sender.createMimeMessage();
		
		try {
			MimeMessageHelper mailMessage = new MimeMessageHelper(message,true);
			
			
			File file = ResourceUtils.getFile(URLpdf);
			mailMessage.setFrom("david310702@gmail.com");
			mailMessage.setTo(to);
			mailMessage.setSubject(subject);
			mailMessage.setText(body);
			mailMessage.addAttachment("Orden de compra", file);
			System.out.println(mailMessage);
			sender.send(message);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
