package review_obj.step2_answer;

import java.util.Random;

/**
 * キャラクタークラス
 *
 */
public class Character {

	/** 性別文字列配列 */
	public static String[] genderStrings = { "未選択", "男性", "女性", "その他" };

	/** プレイヤーid */
	private int id;

	/** 名前 */
	private String name;

	/** 性別 1:男性、2:女性、3:その他 0:未選択 */
	private int gender;

	/** 基礎体力 */
	private int baseHp;

	/** 基礎攻撃力 */
	private int baseAtackPoint;

	/**
	 * フィールドに初期値をセット
	 */
	private Character() {
		setId(1);
		setName("未設定");
		setGender(0);
		setBaseHp(0);
		setBaseAtackPoint(0);
	}

	/**
	 * キャラクター作成時のステータスを決定
	 * @param id キャラクターID
	 * @param name キャラクター名
	 * @param gender 性別
	 */
	public Character(int id, String name, int gender) {
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
		System.out.println("ID：" + getId());
		System.out.println("プレイヤー名：" + getName());
		System.out.println("性別：" + getGendeWithString(gender));
		System.out.println("HP：" + getBaseHp());
		System.out.println("攻撃力：" + getBaseAtackPoint());
	}

	/**
	 * genderの値に応じた性別を文字列でリターンする
	 * 1:男性、2:女性、3:その他 0:未選択
	 * @return 性別文字列
	 */
	public static String getGendeWithString(int gender) {
		return genderStrings[gender];
	}

	/**
	 * キャラクター作成時の体力設定値をリターン
	 * 
	 * @param gender 性別番号
	 * @return 体力値
	 */
	public static int calcBaseHpAtCreateObj(int gender) {
		// ランダム値を取得
		int hp = getRandumNumFromXtoY(1000, 5000);
		// 性別の違いによる倍率計算をしリターン
		return gender == 1 ? (int) (hp * 1.5) : hp;
	}

	/**
	 * キャラクター作成時の攻撃力設定値をリターン
	 */
	public static int calcBaseAtackPowerAtCreateObj(int gender) {
		// ランダム値を取得
		int hp = getRandumNumFromXtoY(100, 1000);
		// 性別の違いによる倍率計算をしリターン
		return gender == 2 ? (int) (hp * 2.0) : hp;
	}

	/**
	 * 整数x～yまでのランダム値を取得
	 * @param x 下限値
	 * @param y 上限値
	 * @return ランダム値
	 */
	public static int getRandumNumFromXtoY(int x, int y) {
		Random rand = new Random();
		return rand.nextInt(y + 1 - x) + x;
	}

	/**
	 * キャラクターIDをセットする
	 * @param id
	 */
	public void setId(int id) {
		if (id > 0) {
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
		if (gender > -1 && gender < genderStrings.length) {
			this.gender = gender;
		}
	}

	/**
	 * 基礎体力をセット
	 * @param baseHp セットする基礎体力
	 */
	public void setBaseHp(int baseHp) {
		if (baseHp >= 0 && baseHp <= 10000) {
			this.baseHp = baseHp;
		} else {
			this.baseHp = 0;
		}
	}

	/**
	 * 基礎攻撃力をセット
	 * @param baseAtackPoint セットする基礎攻撃力
	 */
	public void setBaseAtackPoint(int baseAtackPoint) {
		if (baseAtackPoint >= 0 && baseAtackPoint <= 10000) {
			this.baseAtackPoint = baseAtackPoint;
		} else {
			this.baseAtackPoint = 0;
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
