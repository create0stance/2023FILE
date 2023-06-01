package jp.co.sss.shop.controller.login;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.co.sss.shop.bean.UserBean;
import jp.co.sss.shop.entity.Item;
import jp.co.sss.shop.form.LoginForm;
import jp.co.sss.shop.repository.UserRepository;
import jp.co.sss.shop.service.items.ItemsService;
import jp.co.sss.shop.util.BeanCopy;
import jp.co.sss.shop.util.UrlConstant;

/**
 * ログイン機能のコントローラクラス
 *
 * @author SystemShared
 */
@Controller
public class LoginController {

	/**
	 * 会員情報
	 */
	@Autowired
	UserRepository userRepository;

	/**
	 * 商品情報取得サービス
	 */
	@Autowired
	ItemsService itemsService;

	/**
	 * セッション情報
	 */
	@Autowired
	HttpSession session;

	/**
	 * Topページ表示処理
	 *
	 * @return "index" ログイン画面へ
	 * @throws SQLException
	 */
	@RequestMapping(path = UrlConstant.ROOT, method = RequestMethod.GET)
	public String top(Model model, Pageable pageable) throws SQLException {
		Page<Item> itemPageList = itemsService.findItemsOuterOrderItemOrderCnt(pageable);
		// 注文情報リストをViewへ渡す
		model.addAttribute("pages", itemPageList);
		model.addAttribute("items", BeanCopy.copyEntityToItemBean(itemPageList.getContent()));
		model.addAttribute("url", UrlConstant.ITEM_LIST_DEFAULT);
		return "index";
	}

	/**
	 * ログイン処理
	 *
	 * @param form ログインフォーム
	 * @return "login" ログイン画面へ
	 */
	@RequestMapping(path = UrlConstant.LOGIN, method = RequestMethod.GET)
	public String login( Model model) {

		if(!model.containsAttribute("loginForm")) {
			model.addAttribute("loginForm", new LoginForm());
		}

		// セッション情報を無効にする
		session.invalidate();

		return UrlConstant.LOGIN_VIEW;
	}

	/**
	 * ログイン処理
	 *
	 * @param form ログインフォーム
	 * @param result 入力チェック結果
	 * @param session セッション情報
	 * @return
			一般会員の場合 "/" トップ画面へ
			運用管理者、システム管理者の場合 "admin_menu"へ
	 */
	@RequestMapping(path = UrlConstant.LOGIN, method = RequestMethod.POST)
	public String doLogin(@Valid @ModelAttribute LoginForm form, BindingResult result, RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			// 入力値に誤りがあった場合
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.loginForm", result);
			redirectAttributes.addFlashAttribute("loginForm", form);
			return "redirect:" + UrlConstant.LOGIN;

		} else {

			Integer authority = ((UserBean) session.getAttribute("user")).getAuthority();
			if (authority.intValue() == 2) {
				// 一般会員ログインした場合、トップ画面に遷移
				return "redirect:" + UrlConstant.ROOT;
			} else {
				// 運用管理者、もしくはシステム管理者としてログインした場合、管理者用メニュー画面に遷移
				return "redirect:" + UrlConstant.ADMINMENU;
			}
		}
	}

	@RequestMapping(path = UrlConstant.ADMINMENU, method = RequestMethod.GET)
	public String showAdminMenu() {
		return UrlConstant.ADMIN_MENU;
	}
}
