//2章 基本操作で作成
package jp.co.sss.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class IndexController {
	//2章 
	@RequestMapping(path = "/")
	public String index() {
		return "index";
	}
	
	//3章　画面遷移 遷移前
	@RequestMapping("/before")
	public String before() {
		return "before";
	}

	//3章　画面遷移 遷移後
	@RequestMapping("/after")
	public String after() {
		return "after";
	}

	//3章　フォワード 遷移元画面の表示
	@RequestMapping("/transition")
	public String sampleTransition() {
		return "sample_transition";
	}
	
	//3章　フォワード 遷移先画面の表示
	@RequestMapping("/index_f")
	public String index_forward() {
		return "index";
	}

	//3章　リダイレクト
	@RequestMapping("/index_r")
	public String index_redirect() {
		return "redirect:/";
	}

	//12章 Thymeleaf レイアウト機能の実装 5.コントローラの編集
	@RequestMapping("/layout_view")
	public String layout_view() {
		return "layout_view";
	}



}
