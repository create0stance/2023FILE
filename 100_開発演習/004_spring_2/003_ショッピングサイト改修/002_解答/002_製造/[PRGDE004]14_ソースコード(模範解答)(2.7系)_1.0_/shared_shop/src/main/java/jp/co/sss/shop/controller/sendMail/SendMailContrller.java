package jp.co.sss.shop.controller.sendMail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.sss.shop.form.ContactForm;
import jp.co.sss.shop.util.MyMailSender;

@RestController
public class SendMailContrller {

	@Autowired
	MyMailSender sender;

	@PostMapping("/send_mail/")
	public String sendMail(ContactForm form) {
		try {
			sender.sendMailFromContactForm(form);
			return "OK";
		} catch (Exception e) {
			System.out.println(e);
			return "False";
		}
	}
}
