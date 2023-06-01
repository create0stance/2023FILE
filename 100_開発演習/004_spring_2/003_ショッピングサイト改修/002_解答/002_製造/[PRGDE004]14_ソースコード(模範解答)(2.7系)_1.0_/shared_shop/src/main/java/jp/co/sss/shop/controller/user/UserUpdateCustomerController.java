package jp.co.sss.shop.controller.user;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
 * 一般会員情報更新コントローラー
 *
 * @author TEAM_AKIBA
 *
 */
@Controller
public class UserUpdateCustomerController {

	/** 一般会員サービス */
	@Autowired
	UserService service;

	/**
	 * 一般会員情報更新フォーム - 入力画面
	 * @return 一般会員情報更新 - 入力画面
	 */
	@PostMapping(UrlConstant.USER_UPDATE_URL_INPUT)
	public String updateInput(@Valid @ModelAttribute UserForm form, BindingResult result, Model model, String backflg) {

		// UserFormにidがセットされていなければ、userSessionのidを元に
		// DBから一般会員データを取得しUserFormにセット
		model.addAttribute("userForm", service.getInicialUserForm(form, backflg));

		return UrlConstant.USER_UPDATE_HTML_INPUT;

	}

	/**
	 * 一般会員情報更新フォーム - 入力画面
	 *
	 * @param form 入力フォームデータを保持
	 * @param result	 入力チェック結果
	 * @param model モデル
	 * @return 一般会員情報更新 - 入力画面
	 * @see this.updateCheck
	 */
	@GetMapping(UrlConstant.USER_UPDATE_URL_INPUT)
	public String updateInputRedirect(@Valid @ModelAttribute UserForm form, BindingResult result, Model model) {

		// フォームデータをスコープに保存
		model.addAttribute("userForm", service.getInicialUserForm(form, "false"));
		return UrlConstant.USER_UPDATE_HTML_INPUT;
	}

	/**
	 * 一般会員情報更新-確認画面
	 * @return
	 * 		入力エラーなし：一般会員情報 - 確認画面へリダイレクト
	 * 		入力エラーあり：一般会員情報 - 入力画面ビュー
	 */
	@PostMapping(UrlConstant.USER_UPDATE_URL_CHECK)
	public String updateCheck(@Valid @ModelAttribute UserForm form, BindingResult result,RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			redirectAttributes.addFlashAttribute(form);
			//			redirectAttributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + Conventions.getVariableName(form), result);
			return "redirect:" + UrlConstant.USER_UPDATE_URL_INPUT;
		}

		return UrlConstant.USER_UPDATE_HTML_CHECK;
	}

	/**
	 * 一般会員情報更新-完了処理
	 *
	 * @param form 確認画面でhidden保持されていたFormデータ
	 * @param result 入力チェック結果
	 * @param redirectAttributes リダイレクトスコープ
	 * @return 		通常操作：完了画面へリダイレクト
	 * 					確認画面にてhiddenのvalueに不正操作があった場合 : ログイン画面へリダイレクト
	 */
	@PostMapping(UrlConstant.USER_UPDATE_URL_COMPLETE)
	public String updateComplete(@Valid @ModelAttribute UserForm form, BindingResult result,
			RedirectAttributes redirectAttributes) {

		// 確認画面で不正な操作があった場合、エラー文をスコープに保存しログイン画面にリダイレクト
		if (result.hasErrors() || !service.comparisonFormIdAndBeanId(form)) {
			redirectAttributes.addFlashAttribute(Constant.ERRORS_KEY, service.resetErrorsAndSetError("不正な操作が行われました。"));
			return "redirect:" + UrlConstant.LOGIN;
		}
		// FormデータをDB登録し、セッションに保存
		service.saveSession(service.update(form));
		return "redirect:" + UrlConstant.USER_UPDATE_URL_COMPLETE;
	}

	/**
	 * 一般会員情報更新 完了画面
	 * @return 完了画面ビュー
	 */
	@GetMapping(UrlConstant.USER_UPDATE_URL_COMPLETE)
	public String updateCompleteRedirect() {
		return UrlConstant.USER_UPDATE_HTML_COMPLETE;
	}
}
