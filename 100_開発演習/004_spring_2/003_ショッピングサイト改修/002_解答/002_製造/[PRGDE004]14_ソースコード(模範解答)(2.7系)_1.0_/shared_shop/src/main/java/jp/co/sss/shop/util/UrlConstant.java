package jp.co.sss.shop.util;

/**
 * URL関連定数管理クラス
 *
 * @author TEAM_AKIBA
 *
 */
public class UrlConstant {

	/** 自身のインスタンスを生成 */
	private static UrlConstant urlConstant = new UrlConstant();

	/**
	 * コンストラクタ
	 */
	private UrlConstant() {

	}

	/**
	 * 自身のインスタンスを返す
	 * @return Constant
	 */
	public static UrlConstant getInstance() {

		return urlConstant;
	}

	public static final String ROOT = "/";
	public static final String LOGIN = "/login";
	public static final String LOGOUT = "/logout";
	public static final String INDEX = "index";
	public static final String INPUT = "input";
	public static final String CHECK = "check";
	public static final String COMPLETE = "complete";
	public static final String DETAIL = "/detail";
	public static final String REGIST = "/regist";
	public static final String UPDATE = "/update";
	public static final String DELETE = "/delete";
	public static final String ITEM = "/item";
	public static final String LIST = "/list";
	public static final String BASKET = "/basket";
	public static final String ORDER = "/order";


	/** ユーザー関連フォルダー */
	public static final String USER = "/user";
	/** ユーザー詳細フォルダー */
	public static final String USER_DETAIL = USER + DETAIL;
	/** ユーザー登録フォルダー */
	public static final String USER_REGIST = USER + REGIST;
	/** ユーザー更新フォルダー */
	public static final String USER_UPDATE = USER + UPDATE;
	/** ユーザー削除フォルダー */
	public static final String USER_DELETE = USER + DELETE;


	/** 詳細詳細ビューパス */
	public static final String USER_DETAIL_HTML_INDEX = USER_DETAIL + "/user_detail";

	/** 商品登録-入力画面パス */
	public static final String USER_REGIST_HTML_INPUT = USER_REGIST + "/user_regist_input";
	/** 商品登録-確認画面パス */
	public static final String USER_REGIST_HTML_CHECK = USER_REGIST + "/user_regist_check";
	/** 商品登録-完了画面パス */
	public static final String USER_REGIST_HTML_COMPLETE = USER_REGIST + "/user_regist_complete";

	/** 商品更新-入力画面パス */
	public static final String USER_UPDATE_HTML_INPUT = USER_UPDATE + "/user_update_input";
	/** 商品更新-確認画面パス */
	public static final String USER_UPDATE_HTML_CHECK = USER_UPDATE + "/user_update_check";
	/** 商品更新-完了画面パス */
	public static final String USER_UPDATE_HTML_COMPLETE = USER_UPDATE + "/user_update_complete";

	/** 商品削除-確認画面パス */
	public static final String USER_DELETE_HTML_CHECK = USER_DELETE + "/user_delete_check";
	/** 商品削除-完了画面パス */
	public static final String USER_DELETE_HTML_COMPLETE = USER_DELETE + "/user_delete_complete";

	/** 商品詳細マッピングパス */
	public static final String USER_DETAIL_URL_INDEX = USER + DETAIL;

	/** 商品登録-入力画面マッピングパス */
	public static final String USER_REGIST_URL_INPUT = USER + REGIST + "/" + INPUT;
	/** 商品登録-確認画面マッピングパス */
	public static final String USER_REGIST_URL_CHECK = USER + REGIST + "/" + CHECK;
	/** 商品登録-完了画面マッピングパス */
	public static final String USER_REGIST_URL_COMPLETE = USER + REGIST + "/" + COMPLETE;

	/** 商品更新-入力画面マッピングパス */
	public static final String USER_UPDATE_URL_INPUT = USER + UPDATE + "/" + INPUT;
	/** 商品更新-確認画面マッピングパス */
	public static final String USER_UPDATE_URL_CHECK = USER + UPDATE + "/" + CHECK;
	/** 商品更新-完了画面マッピングパス */
	public static final String USER_UPDATE_URL_COMPLETE = USER + UPDATE + "/" + COMPLETE;

	/** 商品削除-確認画面マッピングパス */
	public static final String USER_DELETE_URL_CHECK = USER + DELETE + "/" + CHECK;
	/** 商品削除-完了画面マッピングパス */
	public static final String USER_DELETE_URL_COMPLETE = USER + DELETE + "/" + COMPLETE;

	/** 商品一覧画面マッピングパス (デフォルト) */
	public static final String ITEM_LIST_DEFAULT = ITEM + LIST + "/" + Constant.DEFAULT_SORT_TYPE;
	/** 商品一覧画面マッピングパス  */
	public static final String ITEM_LIST = ITEM + LIST;


	/** ログイン画面パス */
	public static final String LOGIN_VIEW = "login";

	/** 管理者メニュー画面マッピングパス */
	public static final String ADMINMENU = "/adminmenu";
	/** 管理者メニュー画面パス */
	public static final String ADMIN_MENU = "/admin_menu";

	/** 商品一覧画面マッピングパス */
	public static final String ITEM_DETAIL = ITEM + DETAIL;

	/** 買い物かご一覧画面マッピングパス */
	public static final String BASKET_LIST = BASKET + LIST;
	/** 買い物かご一覧画面パス */
	public static final String BASKET_HTML_LIST = BASKET + "/shopping_basket";
	/** 買い物かご追加処理マッピングパス */
	public static final String BASKET_ADD = BASKET + "/add";
	/** 買い物かご削除処理マッピングパス */
	public static final String BASKET_DELETE = BASKET + DELETE;
	/** 買い物かご全件削除処理マッピングパス */
	public static final String BASKET_ALL_DELETE = BASKET + "/allDelete";

	/** 届け先入力画面マッピングパス */
	public static final String ADDRESS_INPUT = "/address/" + INPUT;
	/** 届け先入力画面パス */
	public static final String ADDRESS_REGIST_INPUT = ORDER + REGIST + "/address_" + INPUT;

	/** 支払い方法入力画面マッピングパス */
	public static final String PAYMENT_INPUT = "/payment/" + INPUT;
	/** 支払い方法入力画面パス */
	public static final String PAYMENT_REGIST_INPUT = ORDER + REGIST + "/payment_" + INPUT;

	/** 注文一覧画面マッピングパス */
	public static final String ORDER_LIST = ORDER + LIST;
	/** 注文一覧画面パス */
	public static final String ORDER_HTML_LIST = ORDER + LIST + "/order_list";
	/** 注文詳細画面マッピングパス */
	public static final String ORDER_DETAIL = ORDER + DETAIL;
	/** 注文詳細画面パス */
	public static final String ORDER_HTML_DETAIL = ORDER + DETAIL + "/order_detail";
	/** 注文登録確認画面マッピングパス */
	public static final String ORDER_CHECK = ORDER + "/" + CHECK;
	/** 注文登録確認画面パス */
	public static final String ORDER_REGIST_CHECK = ORDER + REGIST + ORDER +"_" + CHECK;
	/** 注文登録完了画面マッピングパス */
	public static final String ORDER_COMPLETE = ORDER + "/" + COMPLETE;
	/** 注文登録完了画面パス */
	public static final String ORDER_REGIST_COMPLETE = ORDER + REGIST + ORDER +"_" + COMPLETE;

	/*
	 * Blog関連
	 */
	public static final String BLOG = "/blog";
	public static final String BLOG_DETAIL_URL_INDEX = BLOG + DETAIL;
	public static final String BLOG_DETAIL_INDEX = BLOG + DETAIL;
}
