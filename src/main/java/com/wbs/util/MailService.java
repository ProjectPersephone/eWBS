package com.wbs.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.wbs.domain.User;

@Service("mailService")
public class MailService {

	@Autowired
	private MailSender mailSender;

	@Autowired
	private SimpleMailMessage mailMessage;

	public void sendMail(User user) {
		SimpleMailMessage message = new SimpleMailMessage(mailMessage);
		message.setTo(user.getEmailId());
		message.setText("Hello " + user.getName() + "," + "\n\tWelcome to Nisum. You are added to eWBS for Project : "
				+ user.getProject() + "\nSo Login using the Credentials as given,\n" + "username : " + user.getEmailId()
				+ "\npassword : " + user.getPassword());
		mailSender.send(message);
	}

}
