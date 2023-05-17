//4章 フォーム処理 作成
package jp.co.sss.shop.controller;

import javax.servlet.http.HttpSession; //5章 セッションスコープ 追記
import javax.validation.Valid; //9章 入力チェックの実装 追記

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; //5章 リクエストスコープ 追記
import org.springframework.validation.BindingResult; //9章 入力チェックの実装 追記
import org.springframework.web.bind.annotation.ModelAttribute; //9章 入力チェックの実装 追記
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes; //14章 リダイレクト先へのパラメータ送信 3.コントローラの編集

import jp.co.sss.shop.form.LoginForm; //4章 Formクラスの利用 追記
import jp.co.sss.shop.form.LoginFormWithAnnotation; //10章 独自入力チェックの実装 4.コントローラの編集 追記
import jp.co.sss.shop.form.LoginFormWithValidation; //9章 入力チェックの実装 追記

@Controller
public class SessionController {
	//4章 GET ログイン画面表示
	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String login() {
		return "session/login";
	}

	//4章 GET ログイン画面 「GETによるログイン」ボタンクリック後の処理
	@RequestMapping(path = "/doLogin", method = RequestMethod.GET)
	public String doLoginGet(Integer userId) {
		System.out.println("ユーザ ID:" + userId);
		return "session/login";
	}

	//4章 POST 追記 ログイン画面 「POSTによるログイン」ボタンクリック後の処理
	@RequestMapping(path = "/doLogin", method = RequestMethod.POST)
	public String doLoginPost(Integer userId) {
		System.out.println("ユーザ ID:" + userId);
		return "session/login";
	}

	//4章 Formクラスの利用 追記 ログイン画面表示
	@RequestMapping(path = "/loginUsingForm", method = RequestMethod.GET)
	public String loginUsingForm() {
		return "session/loginUsingForm";
	}

	//4章 Formクラスの利用 追記 ログイン画面 ボタンクリック後の処理
	@RequestMapping(path = "/doLoginUsingForm", method = RequestMethod.POST)
	public String doLoginUsingForm(LoginForm form) {
		System.out.println("ユーザ ID:" + form.getUserId());
		System.out.println("パスワード:" + form.getPassword());
		return "session/loginUsingForm";
	}

	//5章 リクエストスコープ
	@RequestMapping(path = "/loginOnRequest", method = RequestMethod.GET)
	public String loginOnRequest() {
		return "session/loginOnRequest";
	}

	//5章 リクエストスコープ
	@RequestMapping(path = "/doLoginOnRequest", method = RequestMethod.POST)
	public String doLoginOnRequest(LoginForm form, Model model) {
		model.addAttribute("userId", form.getUserId());
		return "session/loginOnRequest";
	}

	//5章 セッションスコープ
	@RequestMapping(path = "/loginOnSession", method = RequestMethod.GET)
	public String loginOnSession() {
		return "session/loginOnSession";
	}

	//5章 セッションスコープ 追記
	@RequestMapping(path = "/doLoginOnSession", method = RequestMethod.POST)
	public String doLoginOnSession(LoginForm form, HttpSession session) {
		if (form.getUserId() == 123) {
			//入力したユーザIDをスコープ変数userIdに代入し、
			//その変数をセッションに登録
			session.setAttribute("userId", form.getUserId());
			return "redirect:/";
		} else {
			return "session/loginOnSession";
		}
	}

	//5章 セッションスコープ 追記
	@RequestMapping(path = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		//セッションの破棄 
		session.invalidate();
		return "redirect:/";
	}

	//9章 入力チェックの実装 追記
	@RequestMapping(path = "/loginWithValidation", method = RequestMethod.GET)
	public String loginWithValidation(@ModelAttribute LoginFormWithValidation form) {
		return "session/loginWithValidation";
	}

	//9章 入力チェックの実装 追記
	@RequestMapping(path = "/loginWithValidation", method = RequestMethod.POST)
	public String doLoginWithValidation(@Valid @ModelAttribute LoginFormWithValidation form, BindingResult result,
			HttpSession session) {

		if (result.hasErrors()) {
			return "session/loginWithValidation";
		}
		if (form.getUserId() == 123) {
			//入力したユーザIDをスコープ変数「userId」に代入し、
			//その変数をセッションに登録
			session.setAttribute("userId", form.getUserId());
			return "redirect:/";
		} else {
			return "session/loginWithValidation";
		}
	}

	//10章 独自入力チェックの実装 4.コントローラの編集 追記
	@RequestMapping(path = "/loginWithAnnotation", method = RequestMethod.GET)
	public String loginWithAnnotation(@ModelAttribute LoginFormWithAnnotation form) {
		return "session/loginWithAnnotation";
	}

	//10章 独自入力チェックの実装 4.コントローラの編集 追記
	@RequestMapping(path = "/loginWithAnnotation", method = RequestMethod.POST)
	public String doLoginWithAnnotation(@Valid @ModelAttribute LoginFormWithAnnotation form,
			BindingResult result, HttpSession session) {
		if (result.hasErrors()) {
			return "session/loginWithAnnotation";
		}
		if (form.getUserId() == 123) {
			//ユーザIDをスコープ変数「userId」に代入し、セッションに登録
			session.setAttribute("userId", form.getUserId());
			return "redirect:/";
		} else {
			return "session/loginWithAnnotation";
		}
	}

	//14章 リダイレクト先へのパラメータ送信 3.コントローラの編集
	@RequestMapping(path = "/loginOnFlash", method = RequestMethod.GET)
	public String loginOnFlash(Model model) {
		//スコープ中に「loginForm」という名前のデータがなかったら(入力エラーがなかったら) 
		// 新規に Form クラスのデータを作成して、リクエストスコープに保存する。
		if (!model.containsAttribute("loginFormWithValidation")) {
			model.addAttribute("loginFormWithValidation", new LoginFormWithValidation());
		}
		return "session/loginOnFlash";
	}

	//14章 リダイレクト先へのパラメータ送信 3.コントローラの編集
	@RequestMapping(path = "/doLoginOnFlash", method = RequestMethod.POST)
	public String doLoginOnFlash(@Valid @ModelAttribute LoginFormWithValidation form,
			BindingResult result, HttpSession session, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			// 入力チェック結果の情報をフラッシュスコープに保存
			redirectAttributes.addFlashAttribute(
					"org.springframework.validation.BindingResult.loginFormWithValidation", result);
			// Form クラスの情報をフラッシュスコープに保存
			redirectAttributes.addFlashAttribute("loginFormWithValidation", form);
			System.out.println("redirect");
			return "redirect:/loginOnFlash";
		}
		if (form.getUserId() == 123) {
			// ユーザ ID をスコープ変数「userId」に代入し、セッションに登録
			session.setAttribute("userId", form.getUserId());
			return "redirect:/";
		} else {
			return "session/loginOnFlash";
		}
	}

}
