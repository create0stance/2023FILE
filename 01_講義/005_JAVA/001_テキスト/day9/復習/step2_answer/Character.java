package review_obj.step2_answer;

import java.util.Random;

/**
 * キャラクタークラス
 *
 */
public class Character {
	
	/** プレイヤーid */
	private int id;
	
	/** 名前 */
	private String name ;
	
	/** 性別 1:男性、2:女性、3:その他 0:未選択 */
	private int gender;
	
	/** 基礎体力 */
	private int baseHp;
	
	/** 基礎攻撃力 */
	private int baseAtackPoint ;
	
	
	
	/**
	 * プレーヤー情報をコンソール出力
	 */
	void showInfomation() {
		System.out.println("ID："+ id);
		System.out.println("プレイヤー名：" + name);
		System.out.println("性別：" + getGendeWithString());
		System.out.println("HP：" + baseHp);
		System.out.println("攻撃力：" + baseAtackPoint);
	}
	
	/**
	 * genderの値に応じた性別を文字列でリターンする
	 * 1:男性、2:女性、3:その他 0:未選択
	 * @return 性別文字列
	 */
	String getGendeWithString(){
		String[] genderStrs = {"未選択","男性","女性","その他"};
		return genderStrs[gender];
	}
	
	/**
	 * キャラクターIDをセットする
	 * @param id
	 */
	public void setId(int id) {
		this.id = 1;
		if(id > 1) {			
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
		this.gender = 0;
		if(gender > 0 && gender < 4) {	
			this.gender = gender;
		}
	}


	/**
	 * 基礎体力に1000～5000のランダム値をセット
	 */
	public void setBaseHp(){
		Random rand = new Random();
		// 引数ありのsetBaseHpメソッドを経由してフィールドにセット
		setBaseHp(rand.nextInt(4001) + 1000);
	}
	/**
	 * 基礎体力をセット
	 * @param baseHp セットする基礎体力
	 */
	public void setBaseHp(int baseHp){
		this.baseHp = 0;
		if(baseHp > 0 && baseHp < 10001) {
			this.baseHp = baseHp;
		}
	}

	/**
	 * 基礎攻撃力に100～1000のランダム値をセットする
	 */
	public void setBaseAtackPoint(){
		Random rand = new Random();
		int randNum = rand.nextInt(901) + 100;
		// 引数ありのsetBaseAtackPointメソッドを経由してフィールドにセット
		this.setBaseAtackPoint(randNum);
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
