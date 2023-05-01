package review_obj;

import java.util.Random;

/**
 * プレイヤーとパートナーが動物と出会い、
 * 属性(良識人、キャンパー、サバイバー、Twitter、Instagrammer)に応じた行動を取る。
 * @author USER
 *
 */
public class Character {
	/** プレイヤーid */
	private int id;
	
	/** 名前 */
	private String name ;
	
	/** 性別 1:男性、2:女性、3:その他 0:未選択 */
	private int gender;
	
	/** 体力 */
	private int hp;
	
	/** 基礎攻撃力 */
	private int baseAtackPoint ;
	
	public void setHp(){
		Random rand = new Random();
//		1000～5000のランダム値をセット
		this.hp =  rand.nextInt(4001) + 1000;
	}
	public void setBaseAtackPoint(){
//		100～1000のランダム値をセット
		Random rand = new Random();
		this.setBaseAtackPoint(rand.nextInt(901) + 100);
	}
	
	void showInfomation() {
		System.out.println("ID："+ id);
		System.out.println("プレイヤー名：" + name);
		System.out.println("性別：" + getGendeWithString());
		System.out.println("HP：" + hp);
		System.out.println("攻撃力：" + baseAtackPoint);
	}
	
	/**
	 * 
	 * @return
	 */
	String getGendeWithString(){
		String[] genderStrs = {"未選択","男性","女性","その他"};
		return genderStrs[gender];
	}
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	public void setId(int id) {
		if(id > 0) {			
			this.id = id;
		}else {
			this.id = 1;
		}
	}
	
	public int getId() {
		return id;
	}
	
	/**
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return gender
	 */
	public int getGender() {
		return gender;
	}


	/**
	 * @param gender セットする gender
	 */
	public void setGender(int gender) {
		if(gender > 0 && gender < 4) {	
			this.gender = gender;
		}else {
			this.gender = 0;
		}
	}


	/**
	 * @return hp
	 */
	public int getHp() {
		return hp;
	}


	/**
	 * @param hp セットする hp
	 */
	public void setHp(int hp) {
		this.hp = hp;
	}

	/**
	 * @return baseAtackPoint
	 */
	public int getBaseAtackPoint() {
		return baseAtackPoint;
	}


	/**
	 * @param baseAtackPoint セットする baseAtackPoint
	 */
	public void setBaseAtackPoint(int baseAtackPoint) {
		this.baseAtackPoint = baseAtackPoint;
	}


	


}
