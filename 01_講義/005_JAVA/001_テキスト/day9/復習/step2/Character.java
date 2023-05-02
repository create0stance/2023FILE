package review_obj.step2;

import java.util.Random;

/**
 * キャラクタークラス
 *
 */
public class Character {
	
	private static String[] genderStrings = {"未選択","男性","女性","その他"};
	
	/** プレイヤーid */
	private int id;
	
	/** 名前 */
	private String name ;
	
	/** 性別 1:男性、2:女性、3:その他 0:未選択 */
	private int gender;
	
	/** 基礎体力 */
	private int baseHp;
	
	/** 基礎口撃力 */
	private int baseAtackPoint;
	
	private Character() {
		setId(1);
		setGender(0);
		setBaseHp(0);
		setBaseAtackPoint(0);
	}
	
	public Character(int id,String name,int gender) {
		this();
		setId(id);
		setName(name);
		setGender(gender);
	}
	

	/**
	 * プレーヤー情報をコンソール出力
	 */
	public void showInfomation() {
		System.out.println("ID："+ id);
		System.out.println("プレイヤー名：" + name);
		System.out.println("性別：" + getGendeWithString(gender));
		System.out.println("HP：" + baseHp);
		System.out.println("攻撃力：" + baseAtackPoint);
	}
	
	/**
	 * genderの値に応じた性別を文字列でリターンする
	 * 1:男性、2:女性、3:その他 0:未選択
	 * @return 性別文字列
	 */
	public static String getGendeWithString(int gender){
		return genderStrings[gender];
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
		if(gender > -1 && gender < genderStrings.length) {	
			this.gender = gender;
		}
	}


	/**
	 * 基礎体力の初期値を計算しリターン
	 */
	public static int calcDefaultBaseHp(int gender){
		int hp = getRandumNumFromXtoY(hpLowerLimit, hpUpaerLimit);
		return gender == 1 ? (int)(hp * maleStrengthMagnification):hp;
	}
	/**
	 * 基礎口撃力の初期値を計算しリターン
	 */
	public static int calcDefaultBaseAtackPower(int gender){
		int hp = getRandumNumFromXtoY(atackPowerLowerLimit, atackPowerUpaerLimit);
		return gender == 2 ? (int)(hp * femaleAtackPowerMagnification):hp;
	}
	private static int defaultHpLowerLimit = 1000;
	private static int defaultHpUpaerLimit = 5000;
	private static int defaultAtackPowerLowerLimit = 100;
	private static int defaultAtackPowerUpaerLimit = 1000;
	private static int hpLowerLimit = 1;
	private static int hpUpaerLimit = 10000;
	private static int atackPowerLowerLimit = 1;
	private static int atackPowerUpaerLimit = 10000;
	private static double maleStrengthMagnification = 2.0;
	private static double femaleAtackPowerMagnification = 2.0;
	
	public static int getRandumNumFromXtoY(int x,int y) {
		Random rand = new Random();
		return rand.nextInt(y+1-x) + x;
	}
	/**
	 * 基礎体力をセット
	 * @param baseHp セットする基礎体力
	 */
	public void setBaseHp(int baseHp){
		if(baseHp > 0 && baseHp < 10001) {
			this.baseHp = baseHp;
		}
	}


	/**
	 * 基礎攻撃力をセット
	 * @param baseAtackPoint セットする基礎攻撃力
	 */
	public void setBaseAtackPoint(int baseAtackPoint) {
		// 初期値をセット
		this.baseAtackPoint = 0;
		if(baseAtackPoint > 0 && baseAtackPoint < 10001) {			
			this.baseAtackPoint = baseAtackPoint;
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
