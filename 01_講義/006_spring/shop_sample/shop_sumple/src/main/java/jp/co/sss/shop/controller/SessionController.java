package jp.co.sss.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.shop.form.LoginForm;

@Controller
public class SessionController {
	
	@RequestMapping(path="/login",method=RequestMethod.GET)
	public String login() {
		return "session/login";
	}
	
	@RequestMapping(path="/doLogin",method=RequestMethod.GET)
	public String doLoginGet(Integer userId) {
		System.out.println(userId);
		return "session/login";
	}
	
	@RequestMapping(path="/doLogin",method=RequestMethod.POST)
	public String doLoginPost(Integer userId) {
		System.out.println(userId);
		return "session/login";
	}
	
	@GetMapping("loginUsingForm")
	public String loginUsingForm() {
		return "session/loginUsingForm";
	}
	
	@PostMapping("doLoginUsingForm")
	public String doLoginUsingForm(LoginForm form) {
		System.out.println(form.getUserId());
		System.out.println(form.getPassword());
		return "session/loginUsingForm";
	}
	
}
