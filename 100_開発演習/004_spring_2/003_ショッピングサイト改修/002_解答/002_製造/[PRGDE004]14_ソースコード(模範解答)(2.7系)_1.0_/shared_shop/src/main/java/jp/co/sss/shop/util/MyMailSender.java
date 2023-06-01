package jp.co.sss.shop.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import jp.co.sss.shop.form.ContactForm;

@Component
public class MyMailSender {

	@Autowired
	private Environment env;

	@Autowired
	MailSender mailSender;

	/**
	 *
	 * @param form
	 */
	public void sendMailFromContactForm(ContactForm form) {
		String adminMail = env.getProperty("spring.mail.username");
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom(adminMail);
		msg.setTo(form.getEmail());
		msg.setSubject(form.getSubject());
		msg.setText(form.getMessage());
		this.mailSender.send(msg);
	}
}
