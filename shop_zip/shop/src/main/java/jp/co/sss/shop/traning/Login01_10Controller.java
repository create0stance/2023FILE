package jp.co.sss.shop.traning;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Login01_10Controller {
	LoginForm login = new LoginForm("taro", "taro");

	Login01_10Controller() {}

	@RequestMapping("/lesson01_10/login")
	public String login(HttpSession session) {
		session.invalidate();
		return "/traning/lesson01_10/login";
	}

	@RequestMapping(path = "/lesson01_10", method = RequestMethod.POST)
	public String doLogin(LoginForm loginForm, HttpSession session) {
		String redirect = null;
		System.out.println("----");
		if ((loginForm.getPassword().equals(login.getPassword()))
				&& (loginForm.getUserId().equals(login.getUserId()))) {
			redirect = "/traning/lesson01_10/top";
			session.setAttribute("user", loginForm.getUserId());
			System.out.println(session.getAttribute("user") + "\n" + session.getId());
		} else {
			redirect = "/traning/lesson01_10/login";
		}
		return redirect;
	}

	@RequestMapping("/lesson01_10/logout")
	public String logout(HttpSession session) {
		System.out.println(session.getAttribute("user") + "\n" + session.getId());
		session.invalidate();
		return "redirect:/lesson01_10/login";
	}
}
