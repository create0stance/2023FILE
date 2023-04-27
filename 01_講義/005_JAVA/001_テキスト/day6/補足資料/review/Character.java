package review;

/**
 * プレイヤーとパートナーが動物と出会い、
 * 属性(良識人、キャンパー、サバイバー、Twitter、Instagrammer)に応じた行動を取る。
 * @author USER
 *
 */
public class Character {
	/** 名前 */
	String name ;
	/** 性別 1:男性、2:女性、3:その他 0:未選択 */
	int gender;
	/** 属性 
	 * 0:未選択、1:一般人、2:Instagrammer、3,Twitter、4:女子高生、5:キャンパー、6:サバイバー)
	 * */
	int type ;
	
	/** 体力 */
	int hp;
	
	/** マジックポイント */
	int mp;
	
	/** 基礎攻撃力 */
	int baseAtackPoint ;
	
	
	/** 持ち物リスト */
	Item[] haveItems ;
	
	String getGendeWithString(){
		String[] genderStrs = {"未選択","男性","女性","その他"};
		return genderStrs[gender];
	}
	
	String getTypeWithString() {
		String[] typeStrs = {"未選択","良識人","インスタグラマー","Twitter","女子高生","キャンパー","サバイバー"};
		return typeStrs[type];
	}

}
