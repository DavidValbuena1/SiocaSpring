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
	
	private String htmlEstructura;
	
	public void sendMail(String to,String subject,String body,String URLpdf) {
		MimeMessage message = sender.createMimeMessage();
		
		try {
			MimeMessageHelper mailMessage = new MimeMessageHelper(message,true);
			
			System.out.println("Estas en el try del envio del correo");
			File file = ResourceUtils.getFile(URLpdf);
			mailMessage.setFrom("david310702@gmail.com");
			mailMessage.setTo(to);
			mailMessage.setSubject(subject);
			mailMessage.setText(body);
			mailMessage.addAttachment("Orden de compra", file);
			sender.send(message);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void recuperarContraseñaEmail(String to) {
		MimeMessage message = sender.createMimeMessage();
		
		try {
			MimeMessageHelper mailMessage = new MimeMessageHelper(message,true);
			
			this.htmlEstructura=String.join(System.getProperty("line.separator"), "<!DOCTYPE html>\r\n"
					+ "<html lang=\"en\">\r\n"
					+ "<head>\r\n"
					+ "    <meta charset=\"UTF-8\">\r\n"
					+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
					+ "    <meta name=\"viewport\" content=\"width=<device-width>, initial-scale=1.0\">\r\n"
					+ "    <title>Document</title>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "    <h1>Correo de recuperación de contraseña</h1>\r\n"
					+ "</body>\r\n"
					+ "</html>");
			mailMessage.setFrom("david310702@gmail.com");
			mailMessage.setTo(to);
			mailMessage.setSubject("Recuperar contraseña");
			mailMessage.setText(this.htmlEstructura,true);
			System.out.println("Apunto de enviar correo");
			sender.send(message);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
