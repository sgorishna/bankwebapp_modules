package com.webapp.controller.admin;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendRegistrationMail {

	static Properties mailServerProperties;
	static Session getMailSession;//
	static MimeMessage generateMailMessage;

	public static void generateAndSendEmail(String email, String login, String password) throws AddressException, MessagingException {

		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");

		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
		generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress(email));
		generateMailMessage.setSubject("Greetings from Bank");
		String emailBody = "Login: " + login + "<br>" + " Password " + password + "<br> Regards, <br> Admin";
		generateMailMessage.setContent(emailBody, "text/html");

		Transport transport = getMailSession.getTransport("smtp");

		transport.connect("smtp.gmail.com", "mybankjava@gmail.com", "java123456");
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();
	}

}
