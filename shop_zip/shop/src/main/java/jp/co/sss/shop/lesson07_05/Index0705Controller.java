package jp.co.sss.shop.lesson07_05;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Index0705Controller {
	
	@GetMapping("/lesson07_05/index")
	public String index() {
		
		return "lesson07_05/index";
	}
	@GetMapping("/lesson07_05/new")
	public String insert() {
		
		return "lesson07_05/new";
	}
	
	

}
