package jp.co.sss.shop.controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jp.co.sss.shop.service.UserService;
import jp.co.sss.shop.util.Constant;
import jp.co.sss.shop.util.UrlConstant;

/**
 * 一般会員ユーザー削除コントローラー
 *
 * @author TEAM_AKIBA
 *
 */
@Controller
public class UserDeleteCustomerController {

	@Autowired
	UserService service;

	/**
	 * ユーザー削除-確認画面
	 * @return ユーザー削除-確認画面ビューパス
	 */
	@PostMapping(UrlConstant.USER_DELETE_URL_CHECK)
	public String UserDeleteCheck(Model model) {
		model.addAttribute("userForm",service.getUserBeanFromSessionUserById());
		return UrlConstant.USER_DELETE_HTML_CHECK;
	}

	/**
	 * ユーザー削除処理
	 * @return ユーザー削除-完了画面ビューパス
	 */
	@PostMapping(UrlConstant.USER_DELETE_URL_COMPLETE)
	public String UserDeleteComplete(HttpSession session) {

		service.delete();
		session.removeAttribute(Constant.USER_SAVE_KEY);

		return "redirect:" + UrlConstant.USER_DELETE_URL_COMPLETE;
	}

	/**
	 * ユーザー削除-完了
	 * @return ユーザー削除-完了画面ビューパス
	 */
	@GetMapping(UrlConstant.USER_DELETE_URL_COMPLETE)
	public String UserDeleteCompleteRedirect() {
		return UrlConstant.USER_DELETE_HTML_COMPLETE;
	}


}
