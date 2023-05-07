package review_obj.step3_answer;

public class Constant {
	// キャメルケース->定数
	// alt shift r
	// ctrl alt k
	// ctrl shift x
	
	/** インスタンス化させない */
	private Constant() {}
	
	/** 整形用　中央線 */
	public static final String CENTER_LINE = "-----------------------------------------";
	/** 整形用　下線 */
	public static final String BOTTOM_LINE = "＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿";
	/** 整形用　上線 */
	public static final String TOP_LINE = "￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣";
	/** 整形用　でこぼこ線 */
	public static final String BUMP_LINE = "＼／＼／＼／＼／＼／＼／＼／＼／＼／＼";
	/** 案内者 */
	public static final String INFOMATOR = "(･8･)";
	/** バトル案内者 */
	public static final String BATTLE_INFOMATOR = "(U・ᴥ・U)";
	
	
	/** ID初期値 */
	public static final int DEFAULT_ID = 1;
	/** 性別初期値 */
	public static final int DEFAULT_GENDER = 0;
	/** キャラクター名初期値 */
	public static final String DEFAULT_NAME = "未設定";
   /** HP下限 */
	public static final int HP_LOWER= 0;
	/**  HP上限 */
	public static final int HP_UPPER= 10000;
	/** 攻撃力下限 */
	public static final int ATACK_POWER_LOWER= 0;
	/** 攻撃力上限 */
	public static final int ATACK_POWER_UPAER= 10000;
	
	/** キャラクター作成時 HP下限*/
	public static final int HP_LOWER_AT_CREATE_OBJ = 1000;
	/** キャラクター作成時 HP上限*/
	public static final int HP_UPPER_AT_CREATE_OBJ = 5000;
	/** キャラクター作成時 攻撃力下限*/ 
	public static final int ATACK_POWER_LOWER_AT_CREATE_OBJ = 100;
	/** キャラクター作成時 攻撃力上限*/
	public static final int ATACK_POWER_UPAER_AT_CREATE_OBJ = 1000;

	/** 男性キャラクター作成時 HP倍率*/
	public static final double MALE_HP_MAGNIFICATION = 1.5;
	/** 女性キャラクター作成時 攻撃力倍率*/
	public static final double MALE_ATACK_POWER_MAGNIFICATION = 2.0;
	
	/** 性別文字列配列 */
	public static final String[] GENDER_STRINGS = {"未選択","男性","女性","その他"};
	/** 性別文字列配列から男性を取得する添え字*/
	public static final int MALE_STRING_INDEX = 1;
	/** 性別文字列配列から女性を取得する添え字*/
	public static final int FEMALE_STRING_INDEX = 2;

}
