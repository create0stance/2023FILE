package jp.co.sss.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sss.shop.entity.Category;//7章 外部キーによる条件検索 2．コントローラの編集 追記
import jp.co.sss.shop.entity.ItemWithCategory;//7章 外部キーによる条件検索 2．コントローラの編集 追記
import jp.co.sss.shop.repository.CategoryRepository;
import jp.co.sss.shop.repository.ItemWithCategoryRepository;

@Controller
public class ItemWithCategoryController {

	/** レポジトリ */
	@Autowired
	private ItemWithCategoryRepository repository;
	
	@Autowired
	private CategoryRepository catReppository;

	/**
	 * 商品一覧表示
	 * @param model Model
	 * @return 商品一覧表示ビュー
	 */
	@RequestMapping("/items/findItemAndCategory")
	public String showItemAndCategoryList(Model model) {

		// 一覧を取得しリクエストスコープに保存
		model.addAttribute("items", repository.findAll());
		

		return "items/item_category_list";
	}

	/**
	 * 商品情報をカテゴリIDで絞り込み表示
	 * @param categoryId 絞り込むカテゴリID
	 * @param model リクエストスコープに保存
	 * @return 商品一覧表示ビュー
	 */
	@RequestMapping("/items/searchByCategoryId/{categoryId}")
	public String searchByCategoryId(
			// パスからカテゴリIDを取得
			@PathVariable Integer categoryId, Model model) {

		//パスで指定されたカテゴリIDを持つEntityを作成
		Category category = new Category();
		category.setId(categoryId);

		//カテゴリで絞り込み検索
		List<ItemWithCategory> items = repository.findByCategory(category);
		
		

		//検索結果をリクエストスコープに保存
		model.addAttribute("items", items);
		
		//商品一覧画面に遷移
		return "items/item_category_list";
	}
	
	/**
	 * カテゴリ一覧を商品情報と合わせて取得
	 * @param model
	 * @return
	 */
	@RequestMapping("/items/findAllCategory")
	public String findAllCategory(Model model) {
		
		List<Category> cats = catReppository.findAll();
		model.addAttribute("cats",cats);
		return "items/categories";
	}


}
