package jp.co.sss.shop.controller.advice;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import jp.co.sss.shop.util.Constant;
import jp.co.sss.shop.util.UrlConstant;

/**
 *
 * 共通処理コントローラー
 * @author TEAM_AKIBA
 *
 */
@ControllerAdvice
@Component
@Order(0)
public class CommonController {

	/**
	 * 定数クラスをリクエストスコープに追加
	 * @param model
	 */
	@ModelAttribute
	public void setConstant(Model model) {
		Constant CONSTANT = Constant.getInstance();
		UrlConstant URL_CONSTANT = UrlConstant.getInstance();
		model.addAttribute("URL",URL_CONSTANT);
		model.addAttribute("CONST",CONSTANT);
	}

}


