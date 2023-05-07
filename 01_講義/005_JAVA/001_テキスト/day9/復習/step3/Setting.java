package review_obj.step3;

public class Setting {
	
	/** 整形用　中央線 */
	public static String centerLine = "-----------------------------------------";
	/** 整形用　下線 */
	public static String bottomLine = "＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿";
	/** 整形用　上線 */
	public static String topLine = "￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣";
	/** 整形用　でこぼこ線 */
	public static String bumpLine = "＼／＼／＼／＼／＼／＼／＼／＼／＼／＼";
	/** 案内者 */
	public static String infomator = "(･8･)";
	/** バトル案内者 */
	public static String battleInfomator = "(U・ᴥ・U)";
	/** インスタンス化させない */
	public Setting() {}
	
	/** ID初期値 */
	public static int defaultId = 1;
	/** 性別初期値 */
	public static int defaultGender = 0;
	/** キャラクター名初期値 */
	public static String defaultName = "未設定";
   /** HP下限 */
	public static int hpLower= 0;
	/**  HP上限 */
	public static int hpUpper= 10000;
	/** 攻撃力下限 */
	public static int atackPowerLower= 0;
	/** 攻撃力上限 */
	public static int atackPowerUpaer= 10000;
	
	/** キャラクター作成時 HP下限*/
	public static int hpLowerAtCreateObj = 1000;
	/** キャラクター作成時 HP上限*/
	public static int hpUpperAtCreateObj = 5000;
	/** キャラクター作成時 攻撃力下限*/ 
	public static int atackPowerLowerAtCreateObj = 100;
	/** キャラクター作成時 攻撃力上限*/
	public static int atackPowerUpaerAtCreateObj = 1000;

	/** 男性キャラクター作成時 HP倍率*/
	public static double maleHpMagnification = 1.5;
	/** 女性キャラクター作成時 攻撃力倍率*/
	public static double maleAtackPowerMagnification = 2.0;
	
	/** 性別文字列配列 */
	public static String[] genderStrings = {"未選択","男性","女性","その他"};
	/** 性別文字列配列から男性を取得する添え字*/
	public static int maleStringIndex = 1;
	/** 性別文字列配列から女性を取得する添え字*/
	public static int femaleStringIndex = 2;
	
}
