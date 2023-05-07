package review_obj.step2;

import java.util.Random;

/**
 * キャラクタークラス
 *
 */
public class Character {

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

	// 2_1)2_2)コンストラクタを定義せよ
	/**
	 * フィールドに初期値をセット
	 */

	/**
	 * キャラクター作成時のステータスを決定
	 * @param id キャラクターID
	 * @param name キャラクター名
	 * @param gender 性別
	 */
	
	/**
	 * プレーヤー情報をコンソール出力
	 */
	public void showInfomation() {
		System.out.println("ID："+ getId());
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
	String getGendeWithString(int gender){
		// 1_2)static変数で配列情報を管理せよ
		String[] genderStrs = {"未選択","男性","女性","その他"};
		return genderStrs[gender];
	}

	/**
	 * 引数なし基礎体力セッター
	 * 1000～5000のランダム値をセット
	 */
	// 1_1)③引数なしのセッターを削除
	public void setBaseHp(){
		Random rand = new Random();
//		1000～5000のランダム値をセット
		this.baseHp =  rand.nextInt(4001) + 1000;
	}
	/**
	 * キャラクター作成時の体力設定値をリターン
	 * 
	 * @param gender 性別番号
	 * @return 体力値
	 */
//	1_1）①
	
	/**
	 * 引数なし基礎攻撃力セッター
	 * 100～1000のランダム値をセット
	 */
	// 1_1)③引数なしのセッターを削除
	public void setBaseAtackPoint(){
//		100～1000のランダム値をセット
		Random rand = new Random();
		this.setBaseAtackPoint(rand.nextInt(901) + 100);
	}

	/**
	 * キャラクター作成時の攻撃力設定値をリターン
	 */
//	1_1)②

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
		} else {
			this.id = 1;
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
		if(gender > 0 && gender < 4) {	
			this.gender = gender;
		}else {
			this.gender = 0;
		}
	}
	

	/**
	 * 基礎体力をセット
	 * @param baseHp セットする基礎体力
	 */
	public void setBaseHp(int baseHp) {
		if(baseHp >= 0 && baseHp <= 10000) {
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
		if(baseAtackPoint >= 0 && baseAtackPoint <= 10000) {
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
