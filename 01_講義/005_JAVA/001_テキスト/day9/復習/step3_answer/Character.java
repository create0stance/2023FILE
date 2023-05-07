package review_obj.step3_answer;

import java.util.Date;
import java.util.Random;

/**
 * キャラクタークラス
 *
 */
public class Character {

	/** プレイヤーid */
	protected int id;
	
	/** 名前 */
	protected String name ;
	
	/** 性別 1:男性、2:女性、3:その他 0:未選択 */
	protected int gender;
	
	/** 基礎体力 */
	protected int baseHp;
	
	/** 基礎攻撃力 */
	protected int baseAtackPoint;
	
	/** キャラクター作成日時 */
	protected Date createDate;
	
	/**
	 * @return createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}
	
	

	/**
	 * @param createDate セットする createDate
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * フィールドに初期値をセット
	 */
	private Character() {
		setId(Constant.DEFAULT_ID);
		setName(Constant.DEFAULT_NAME);
		setGender(Constant.DEFAULT_GENDER);
		setBaseHp(Constant.HP_LOWER);
		setBaseAtackPoint(Constant.ATACK_POWER_LOWER);
		setCreateDate(new Date());
		
	}
	
	/**
	 * キャラクター作成時のステータスを決定
	 * @param id キャラクターID
	 * @param name キャラクター名
	 * @param gender 性別
	 */
	public Character(int id,String name,int gender) {
		// 引数なしコンストラクタを呼び出し、初期値をセット
		this();
		// 各フィールドに引数で受け取った値をsetterを通しセット
		setId(id);
		setName(name);
		setGender(gender);
		// hpと攻撃力をセット
		setBaseHp(calcBaseHpAtCreateObj(getGender()));
		setBaseAtackPoint(calcBaseAtackPowerAtCreateObj(getGender()));
	}
	

	/**
	 * プレーヤー情報をコンソール出力
	 */
	public void showInfomation() {
		System.out.println("ID："+ getId());
		System.out.println("プレイヤー名：" + getName());
		System.out.println("性別：" + getGendeWithString(gender));
		System.out.println("HP：" + getBaseHp());
		System.out.println("攻撃力：" + getBaseAtackPoint());
		System.out.println("作成日時：" + Common.getDateWithString(getCreateDate()));
	}
	
	/**
	 * genderの値に応じた性別を文字列でリターンする
	 * 1:男性、2:女性、3:その他 0:未選択
	 * @return 性別文字列
	 */
	public static String getGendeWithString(int gender){
		return Constant.GENDER_STRINGS[gender];
	}
	/**
	 * キャラクター作成時の体力設定値をリターン
	 * 
	 * @param gender 性別番号
	 * @return 体力値
	 */
	public static int calcBaseHpAtCreateObj(int gender){
		// ランダム値を取得
		int hp = getRandumNumFromXtoY(Constant.HP_LOWER_AT_CREATE_OBJ, Constant.HP_UPPER_AT_CREATE_OBJ);
		// 性別の違いによる倍率計算をしリターン
		return gender == Constant.MALE_STRING_INDEX ? (int)(hp * Constant.MALE_HP_MAGNIFICATION):hp;
	}
	/**
	 * キャラクター作成時の攻撃力設定値をリターン
	 */
	public static int calcBaseAtackPowerAtCreateObj(int gender){
		// ランダム値を取得
		int hp = getRandumNumFromXtoY(Constant.ATACK_POWER_LOWER_AT_CREATE_OBJ, Constant.ATACK_POWER_UPAER_AT_CREATE_OBJ);
		// 性別の違いによる倍率計算をしリターン
		return gender == Constant.FEMALE_STRING_INDEX ? (int)(hp * Constant.MALE_ATACK_POWER_MAGNIFICATION):hp;
	}
	
	
	/**
	 * 整数x～yまでのランダム値を取得
	 * @param x 下限値
	 * @param y 上限値
	 * @return ランダム値
	 */
	public static int getRandumNumFromXtoY(int x,int y) {
		Random rand = new Random();
		return rand.nextInt(y+1-x) + x;
	}
	
	/**
	 * キャラクターIDをセットする
	 * @param id
	 */
	public void setId(int id) {
		if(id > 0) {			
			this.id = id;
		}
	}
	
	/**
	 * キャラクター名のセット
	 * @param name セットするキャラクター名
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 性別を数値でセットする
	 * (0:未指定,1:男性,2:女性,3:その他)
	 * @param gender セットする数値
	 */
	public void setGender(int gender) {
		if(gender > -1 && gender < Constant.GENDER_STRINGS.length) {	
			this.gender = gender;
		}
	}

	/**
	 * 基礎体力をセット
	 * @param baseHp セットする基礎体力
	 */
	public void setBaseHp(int baseHp){
		if(baseHp >= Constant.HP_LOWER && baseHp <= Constant.HP_UPPER) {
			this.baseHp = baseHp;
		}else {
			this.baseHp = Constant.HP_LOWER;
		}
	}

	/**
	 * 基礎攻撃力をセット
	 * @param baseAtackPoint セットする基礎攻撃力
	 */
	public void setBaseAtackPoint(int baseAtackPoint) {
		if(baseAtackPoint >= Constant.ATACK_POWER_LOWER && baseAtackPoint <= Constant.ATACK_POWER_UPAER) {			
			this.baseAtackPoint = baseAtackPoint;
		}else {
			this.baseAtackPoint = Constant.ATACK_POWER_LOWER;
		}
	}

	/**
	 * キャラクターIDの取得
	 * @return キャラクターID 
	 */
	public int getId() {
		return id;
	}
	/**
	 * キャラクター名の取得
	 * @return name キャラクター名
	 */
	public String getName() {
		return name;
	}


	/**
	 * 基礎攻撃力の取得
	 * @return baseAtackPoint 基礎攻撃力
	 */
	public int getBaseAtackPoint() {
		return baseAtackPoint;
	}
	
	/**
	 * 性別を数値で取得
	 * @return gender 性別(0:未指定,1:男性,2:女性,3:その他)
	 */
	public int getGender() {
		return gender;
	}


	/**
	 * 基礎体力を取得
	 * @return baseHp 基礎体力
	 */
	public int getBaseHp() {
		return baseHp;
	}

}
