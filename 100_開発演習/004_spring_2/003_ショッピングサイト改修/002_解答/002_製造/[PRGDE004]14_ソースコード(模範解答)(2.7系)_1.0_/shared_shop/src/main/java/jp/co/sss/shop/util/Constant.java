package jp.co.sss.shop.util;

/**
 * 定数定義用クラス
 *
 * @author SystemShared
 */
public class Constant {

	/** 自身のインスタンスを生成 */
	private static Constant constant = new Constant();

	/** コンストラクタ */
	private Constant() {	}

	/**
	 * 自身のインスタンスを返す
	 * @return Constant
	 */
	public static Constant getInstance() {
        return constant;
    }

	/** ユーザー情報の登録・変更・削除時のUserFormセッション保存キー */
	public static final String USER_CRUD_SAVE_KEY = "user_crud_save_key";

	/** ユーザー情報の登録・変更・削除時のUserFormセッション保存キー */
	public static final String ERRORS_KEY = "errors";

	/** セッションにユーザーを保存するキー */
	public static final String USER_SAVE_KEY = "user";

	/** 削除フラグの値(未削除状態) */
	public static final int		NOT_DELETED			= 0;

	/** 削除フラグの値(削除状態) */
	public static final int		DELETED				= 1;

	/** 一般会員フラグの値 */
	public static final int SHOP_MEMBER_AUTHORITY = 2;

	/** インデックス番号の初期値 */
	public static final int		DEFAULT_INDEX		= 1;

	/** 表示順の初期値(新着順) */
	public static final int		DEFAULT_SORT_TYPE	= 1;

	/** 表示順(売れ筋順) */
	public static final int		SALE_CNT_SORT_TYPE	= 2;

	/** 戻るフラグの値（戻るボタン押下時） */
	public static final int 		BACK_FLG_TRUE = 1;


	/**
	 * 商品画像のアップロード先 (注意) ファイルの保存場所はeclipseの環境構築の操作内容によってことなる場合があります。
	 * ファイルアップロードに失敗した場合は、下記のパスを修正してください。
	 */
	public static final String FILE_UPLOAD_PATH = "C:/team/team_akiba/shared_shop/src/main/resources/static/img";

//	public static final String myPass = System.getProperty("java.class.path");
	public static final String myPass = "\\src\\main\\resources\\static\\img";

	/** CSS保存用フォルダの名前 */
	public static final String CSS_FOLDER = "/css/";

	/** 画像ファイル保存用フォルダの名前 */
	public static final String IMAGE_FOLDER = "/img/";
}
