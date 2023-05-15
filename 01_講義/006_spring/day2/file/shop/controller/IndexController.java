package jp.co.sss.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	/**
	 * TOPページ
	 * @return TOP画面ビュー
	 */
	@RequestMapping(value = {"/","/index","index.html"})
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
	 * 
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
	
	/**
	 * フォワード（内部転送処理）試す
	 * @return TOPページ
	 */
	@RequestMapping("/index_f")
	public String index_forward() {
		// ====================
		// フォワード内部転送
		// ====================
		// テンプレートファイルを指定
		return "index";
//		// パスを指定
//		return "forward:/";
//		 メソッド名を指定
//		return index();
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
