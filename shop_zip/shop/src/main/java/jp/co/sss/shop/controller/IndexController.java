package jp.co.sss.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	/**
	 * TOPページ
	 * @return TOP画面ビュー
	 */
	// ※/item/list/削除
	@RequestMapping(path = {"/","/item/list"})
//	@ResponseBody
	public String index() {
		return "index";
	}
	
	/**
	 * リンクでのページ遷移を試す：リンク元
	 * @return ビューパス
	 */
	@RequestMapping("/before")
	public String before() {
		return "before";
	}
	
	/**
	 * リンクでのページ遷移を試す：リンク先
	 * @return
	 */
	@RequestMapping("/after")
	public String after() {
		return "after";
	}
	
	/**
	 * フォワード（内部処理）を試す：遷移元
	 * @return
	 */
	@RequestMapping("/transition")
	public String sampleTransition(){
		return "sample_transition";
	}
	
	// b,e,f
	public String testForword() {
		System.out.println("testForword");
		return "forward:/";
	}
	
	// forwardとredirectの違いとは？
	// forward:他の処理へ経由していく
	// redirect:別のURLへアクセスしてください。
	// redirect時のreturn文の書き方で気を付ける事は？
	/**
	 * フォワード（内部転送処理）試す
	 * @return TOPページ
	 */
	@RequestMapping("/index_f")
	public String index_forward() {
		// ====================
		// フォワード内部転送
		// ====================
		// テンプレートファイルを指定し、
		// HTML作成処理に転送
//		return "index";
//		// パスを指定し、別の処理へ転送
//		return "forward:/";
//		//メソッド名を指定し、
//		//他のメソッドへ処理を転送
//		return index();
		return testForword();
		// ↑全てフォワード
	}
	
	/**
	 * リダイレクト（再リクエスト）を試す
	 * @return TOPページへリダイレクト
	 */
	@RequestMapping("index_r")
	public String indexRedirect() {
		return "redirect:/";
	}
}







