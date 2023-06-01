package jp.co.sss.shop.controller.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jp.co.sss.shop.util.UrlConstant;

@Controller
public class ShowPostCustomer {

	@GetMapping(UrlConstant.BLOG_DETAIL_URL_INDEX)
	public String showPostDetail() {
		return UrlConstant.BLOG_DETAIL_INDEX;
	}

}
