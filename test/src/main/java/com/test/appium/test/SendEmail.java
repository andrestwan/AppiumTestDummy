package com.test.appium.test;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendEmail {

public void sendEmailatt(String path){
		
		
		String to = "andre.dancil@gmail.com";
		
		String from = "andre.chigga@gmail.com";
		
		final String username = "andre.chigga@gmail.com";
		final String password = "dancil361";
		
		String host = "smtp.gmail.com";
		
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
		
		//GET Object
		
		Session session = Session.getInstance(props, new javax.mail.Authenticator(){
			protected PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication(username, password);
			}
		});
		
		try {
			
			Message message = new MimeMessage(session);
			
			message.setFrom(new InternetAddress(from));
			
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			
			message.setSubject("RESULT APPIUM");
			
			BodyPart messageBodyPart = new MimeBodyPart();
			
			messageBodyPart.setText("Berikut Hasil result yg sudah dijalankan");
			
			Multipart multipart = new MimeMultipart();
			
			multipart.addBodyPart(messageBodyPart);
			
			// attachment
			messageBodyPart = new MimeBodyPart();
			
		//	String filename = "target/Result/resultreport.html";
			String filename = path;
			DataSource source = new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(filename);
			multipart.addBodyPart(messageBodyPart);
			
			message.setContent(multipart);
			
			
			//send mesage
			Transport.send(message);
			
			System.out.println("Email Terkirim....");
			
			
			
		} catch (MessagingException e){
			throw new RuntimeException(e);
		}
		
	}
}
