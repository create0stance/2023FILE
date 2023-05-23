package jp.co.sss.shop.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.shop.bean.ItemBean;
import jp.co.sss.shop.entity.Item;
import jp.co.sss.shop.form.ItemForm;
import jp.co.sss.shop.form.LoginFormWithValidation;
import jp.co.sss.shop.repository.ItemRepository;

/**
 * 商品アイテムに関連するコントローラー
 *
 */
@Controller
public class ItemController {

	// DIコンテナからItemRepositoryを取得
	@Autowired
	ItemRepository repository;

	// レポジトリをAutowiredした時点で実行確認。
	// →起動できなければ、Entityまたはレポジトリの実装に間違いがある。
	@RequestMapping("/items/findAll")
	public String showItemList(Model model) {

		// 実装クラス「SimpleJpaRepository」のfindAll()メソッドを使用し、
		// 全件のデータをList<Entity>で取得
		List<Item> items = repository.findAll();

		// コンソールで内容を確認
		for (Item item : items) {
			System.out.println(item);
		}

		// modelにList<Items>を変数名「items」で保存
		model.addAttribute("items", repository.findAll());

		return "items/item_list";
	}

	@RequestMapping("/items/findAllByOrderByPriceDesc")
	public String showItemListByOrderByPriceDesc(Model model) {
		model.addAttribute("items", repository.findAllByOrderByPriceDesc());
		return "items/item_list";
	}

	/**
	 * 主キーで検索し、商品情報を表示
	 * @param id 主キー
	 * @param model Model
	 * @return 商品個別ページ
	 */
	// PathVariabel = パス変数
	// パスの中に{変数名}と記述することで、
	// URLに記載された文字列を動的に取得できる。
	// [使い方]
	// ①パス内の任意の箇所に{変数名}と記述
	// ②引数に以下を記述：
	// @PathVariable 型 変数名 
	// ③メソッド内で指定した変数名で値を使える
	@RequestMapping("/items/getOne/{id}")
	public String showItem(@PathVariable int id, Model model) {

		// getReferenceById(主キー)で、
		// 該当するレコードを1件取得
		// ★戻り値は、Entityの型で取得出来る。
		Item item = repository.getReferenceById(id);

		// HTML出力用のBeanへの詰め替え
		ItemBean itemBean = new ItemBean();
		// ★BeanUtils.copyProperties
		// オブジェクトをディープコピーする。
		// 別のクラスの同じ名称のフィールドへ値をコピー。
		// 型の変換も行ってくれるが、
		// 基本的に違う型への変換はデフォルトでは、
		// 行ってくれないため過信は禁物。
		// 異なる型のフィールドへ変換するには
		// Converterインターフェイスを継承し、
		// 独自のコンバーターを作成し、利用する必要がある。

		// beanにentityのフィールドをコピー
		BeanUtils.copyProperties(item, itemBean);
		// 表示用の情報をbeanに追加
		itemBean.setCategoryName("果物");
		itemBean.setDescription("おいしいよ！！");
		itemBean.setStock(100);

		//コンソールに出力
		System.out.println(itemBean);

		model.addAttribute("item", itemBean);

		return "items/item";
	}

	@RequestMapping("/items/findByPrice/{price}")
	public String showItemListByPrice(@PathVariable Integer price, Model model) {
		model.addAttribute("items", repository.findByPrice(price));
		return "items/item_list";
	}

	@RequestMapping("/items/findByNameAndPrice/{name}/{price}")
	public String showItemListByNameAndPrice(
			@PathVariable String name, @PathVariable Integer price, Model model) {
		model.addAttribute("items", repository.findByNameAndPrice(name, price));
		return "items/item_list";
	}

	/** 
	 * パスに含まれる文字列が含まれる商品を検索
	 * @param name 検索文字列
	 * @param model Model
	 * @return 商品一覧ページビュー
	 */
	@RequestMapping("/items/findByNameLike/{name}/{name2}")
	public String showItemListByNameLike(
			@PathVariable String name,
			@PathVariable String name2,
			Model model) {
		System.out.println(repository);
		model.addAttribute("items", repository.findByNameContainingOrNameContaining(name, name2));
		return "items/item_list";
	}

	/**
	 * ドロップダウンメニューの表示
	 * @param model Model
	 * @return 商品検索フォーム
	 */
	@RequestMapping("/items/findAllAndSetDropdown")
	public String itemListSetDropdown(Model model) {

		// 商品一覧を取得しスコープに保存
		model.addAttribute("items", repository.findAll());

		// 商品検索フォーム
		return "items/item_list_dropdown";
	}

	/**
	 * 選択したセレクトボックスの値から商品を表示
	 * @param itemdrop 選択した商品ID
	 * @param model Model
	 * @return 商品詳細ページ
	 */
	@RequestMapping("/items/findOneFromDropdown")
	public String findOneFromDropdown(
			// SELECTボックスの選択値
			Integer itemdrop,
			// checkboxの選択値
			Integer[] checkName,
			// ラジオボタンの選択値
			Integer selectedRadio, Model model) {

		// 送信された商品IDの商品を検索し、スコープに保存
		model.addAttribute("item", repository.getReferenceById(itemdrop));

		//[補足]radioボタンから送信された値をコンソール出力
		System.out.println("radio：" + selectedRadio);

		//[補足]checkboxから送信された値をコンソール出力
		for (int i = 0; i < checkName.length; i++) {
			System.out.println("checkbox：" + checkName[i]);
		}

		return "items/item";
	}

	/**
	 * 商品登録フォームを表示
	 * @return 商品登録フォーム
	 */
	@RequestMapping("/items/create/input")
	public String createInput() {
		return "items/create_input";
	}

	/**
	 * 商品情報を登録し、商品詳細ページを表示
	 * 
	 * @param form 商品登録フォームクラス
	 * @param model リクエストスコープ
	 * @return 商品詳細ページ
	 */
	@RequestMapping(path = "/items/create/complete")
	public String createComplete(ItemForm form, Model model) {

		// ■saveメソッド
		// repository.save(entity);
		// ↑これだけで登録できる！
		Item item = new Item();

		// Formクラスの値をid以外コピー
		BeanUtils.copyProperties(form, item, "id");
		// レコードを新規登録し、登録後の状態を取得
		item = repository.save(item);
		// ItemBeanにコピー
		ItemBean itemBean = new ItemBean();
		BeanUtils.copyProperties(item, itemBean);

		//リクエストスコープにbeanを保存
		model.addAttribute("item", itemBean);
		model.addAttribute("message",
				"主キー「" + item.getId() + "」の商品が追加されました。");

		// 商品詳細ページへ処理を転送
		return "items/item";
	}

	/**
	 * 商品情報更新フォーム
	 * @param id 更新する商品ID
	 * @param model Model
	 * @return 商品更新フォーム
	 */
	@RequestMapping("/items/update/input/{id}")
	public String updateInput(
			// パス内の{id}の文字列を数値に変換し取得
			@PathVariable Integer id,
			Model model) {
		// 更新対象のレコードを保管したEntityの取得
		Item item = repository.getReferenceById(id);

		// 表示用のBeanを準備
		ItemBean itemBean = new ItemBean();

		// Beanにフィールド値をコピー
		BeanUtils.copyProperties(item, itemBean);

		//リクエストスコープに保存
		model.addAttribute("item", itemBean);

		// 入力フォームのパスをリターン
		return "items/update_input";
	}

	/**
	 * 商品情報更新処理
	 * @param id 更新する商品のID
	 * @param form 更新フォームクラス
	 * @param model Model
	 * @return 商品詳細ページ
	 */
	@RequestMapping(path = "/items/update/complete/{id}", method = RequestMethod.POST)
	public String updateComplete(
			// 更新する商品ID
			@PathVariable Integer id,
			// 更新フォーム
			ItemForm form, Model model) {

		// 更新する商品のIDを指定し、レコードを取得し
		// Entityに保管。
		Item item = repository.getReferenceById(id);

		// Formから送られたデータをEntityにコピー
		BeanUtils.copyProperties(form, item, "id");

		// Entityにidがセットされているので、更新処理
		item = repository.save(item);

		// 表示用のbeanに更新後の値をコピー
		ItemBean itemBean = new ItemBean();
		BeanUtils.copyProperties(item, itemBean);

		// リクエストスコープに保存
		model.addAttribute("item", itemBean);

		return "items/item";
	}

	/**
	 * 商品削除：フォーム表示
	 * @param model Model
	 * @return 商品フォーム
	 */
	@RequestMapping("/items/delete/input")
	public String deleteInput(Model model) {
		
		// 表示確認用にレコードを全件取得し、
		// List<Item>にセットし、リクエストスコープに保存
		model.addAttribute("items", repository.findAll());
		
		//削除フォームパスをリターン
		return "items/delete_input";
	}

	/**
	 * 商品削除：実行処理
	 * @param form 商品フォームクラス
	 * @return 商品一覧へリダイレクト
	 */
	@RequestMapping(path = "/items/delete/complete")
	public String deleteComplete(ItemForm form) {
		
		// formから取得したidを指定し、レコードを削除
		repository.deleteById(form.getId());
		
		// 商品一覧へリダイレクト
		return "redirect:/items/findAll";
	}
	
	@Transactional
	@RequestMapping(path = "/items/test_transition")
	public String testTransition() {
		
		Item yama = new Item();
		yama.setName("山");
		yama.setPrice(1000);
		repository.save(yama);
		
		Item kawa = new Item();
		kawa.setName("川");
		kawa.setPrice(10000000);
		repository.save(kawa);
		
		// 商品一覧へリダイレクト
		return "redirect:/items/findAll";
	}
	
	/**
	 * Thymeleafの記述方法を試してみよう
	 * @return
	 */
	@RequestMapping("/items/thymeleaf_challenge")
	public String thymeleafChallenge(
			@Valid @ModelAttribute LoginFormWithValidation form,
			BindingResult result,
			HttpSession session,
			Model model) {
		
		// [12-2]id1の商品を変数名itemで保存
		model.addAttribute("item",repository.getReferenceById(1));
		
		// [12-3]エスケープ処理
		String html = "<h2>Thymeleafの記述を学ぼう</h2>";
		model.addAttribute("h2tag", html);
		
		// [12-10/12-19]th:checked/th:switch
		model.addAttribute("gender",2);
		
		// [12-11]th:checked
		model.addAttribute("category_id",2);
		
		// [12-12]th:each
		model.addAttribute("items",repository.findAllByOrderByPriceDesc());
		
		// [12-16/12-17]session
		session.setAttribute("bean", null);
		session.setAttribute("userId", 123);
		
		// [リスト以外の被繰り返し変数]Model(map)を保存
		model.addAttribute("model", model);
		
		// [12-3]演算子の種類
		model.addAttribute("animalName","エゾシカ");
		model.addAttribute("price",100000);
		
		//[12-20/12-21]ユーティリティオブジェクト
		model.addAttribute("emptyList",new ArrayList<String>());
		model.addAttribute("today", new Date());
		
		return "items/thymeleaf";
	}
	//
	//    //12章 CSSとJavaScriptの利用 3.コントローラの編集 追記
	//    @RequestMapping("/items/findAllJs")
	//    public String showItemListJs(Model model) {
	//    	model.addAttribute("items", repository.findAll());
	//    	return "items/item_list_js";
	//    }
	//

}
