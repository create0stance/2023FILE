package jp.co.sss.shop.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sss.shop.service.UserService;
import jp.co.sss.shop.util.Constant;
import jp.co.sss.shop.util.UrlConstant;

@Controller
public class UserShowCustomerController {

	/** ユーザーサービス */
	@Autowired
	UserService service;

	/**
	 * ユーザー詳細画面
	 * @return ユーザー詳細画面ビュー
	 */
	@RequestMapping(UrlConstant.USER_DETAIL_URL_INDEX)
	public String UserDetailIndex(Model model) {

		// sessionに保存されているユーザーIDからUserBeanを取得しスコープに保存
		model.addAttribute(Constant.USER_SAVE_KEY,service.getUserBeanFromSessionUserById());

		return UrlConstant.USER_DETAIL_HTML_INDEX;
	}

}
