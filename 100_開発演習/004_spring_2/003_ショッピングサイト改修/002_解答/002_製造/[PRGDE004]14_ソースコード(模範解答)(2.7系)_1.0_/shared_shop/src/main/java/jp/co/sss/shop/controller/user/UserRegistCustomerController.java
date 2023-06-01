package jp.co.sss.shop.controller.user;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Conventions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.co.sss.shop.form.UserForm;
import jp.co.sss.shop.service.UserService;
import jp.co.sss.shop.util.Constant;
import jp.co.sss.shop.util.UrlConstant;

/**
 * ユーザー登録コントローラー
 * @author TEAM_AKIBA
 *
 */
@Controller
public class UserRegistCustomerController {

	@Autowired
	UserService service;

	/**
	 * ユーザー新規登録-入力画面
	 *
	 * @param model
	 * @return
	 */
	@GetMapping(UrlConstant.USER_REGIST_URL_INPUT)
	public String registInput(Model model) {
		if(!model.containsAttribute("userForm")) {
			model.addAttribute(new UserForm());
		}
		return UrlConstant.USER_REGIST_HTML_INPUT;
	}

	/**
	 * 入力確認画面の戻るボタン押下時の処理
	 *
	 * @param form 会員情報の入力値を保持
	 * @param result 入力チェック結果
	 * @return 新規登録画面ビュー
	 */
	@PostMapping(UrlConstant.USER_REGIST_URL_INPUT)
	public String registInputBack(@Valid UserForm form, BindingResult result) {
		return UrlConstant.USER_REGIST_HTML_INPUT;
	}

	/**
	 * ユーザー新規登録-確認画面
	 * @return
	 * 	入力エラーあり：会員情報ー入力画面
	 * 	入力エラーなし：入力情報ー確認画面
	 */
	@PostMapping(UrlConstant.USER_REGIST_URL_CHECK)
	public String UserRegistCheck(@Valid UserForm form, BindingResult result,RedirectAttributes ra) {
		if (result.hasErrors()) {
			ra.addFlashAttribute(form);
			ra.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + Conventions.getVariableName(form), result);
			return "redirect:" + UrlConstant.USER_REGIST_URL_INPUT;
		}
		return UrlConstant.USER_REGIST_HTML_CHECK;
	}

	/**
	 * 会員データ新規登録処理
	 * @return
	 * 	エラーあり：ログイン画面へリダイレクト
	 * 	エラーなし：完了画面へリダイレクト
	 */
	@PostMapping(UrlConstant.USER_REGIST_URL_COMPLETE)
	public String userRegistComplete(@Valid @ModelAttribute UserForm form, BindingResult result,
			RedirectAttributes redirectAttributes) {

		// 確認画面で不正な操作があった場合、エラー文をスコープに保存しログイン画面にリダイレクト
		if (result.hasErrors()) {
			redirectAttributes.addFlashAttribute(Constant.ERRORS_KEY, service.resetErrorsAndSetError("不正な操作が行われました。"));
			return "redirect:" + UrlConstant.LOGIN;
		}

		// FormデータをDB登録し、セッションに保存
		service.saveSession(service.insert(form));

		return "redirect:" + UrlConstant.USER_REGIST_URL_COMPLETE;
	}

	/**
	 * ユーザー新規登録-完了画面
	 * @return 一般会員登録 - 完了画面
	 */
	@GetMapping(UrlConstant.USER_REGIST_URL_COMPLETE)
	public String userRegistCompleteRedirect() {

		return UrlConstant.USER_REGIST_HTML_COMPLETE;
	}

}
