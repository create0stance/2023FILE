package review_obj.step4_answer;

public class Reader extends Character {

	public Reader(int id, String name, int gender) {
		super(id, name, gender);
	}
	
	@Override
	public void setBaseHp(int baseHp){
		if(baseHp >= Setting.hpLower && baseHp <= Setting.hpUpper*2) {
			this.baseHp = baseHp;
		}else {
			this.baseHp = Setting.hpLower;
		}
	}

	/**
	 * 基礎攻撃力をセット
	 * @param baseAtackPoint セットする基礎攻撃力
	 */
	@Override
	public void setBaseAtackPoint(int baseAtackPoint) {
		if(baseAtackPoint >= Setting.atackPowerLower && baseAtackPoint <= Setting.atackPowerUpaer * 2) {			
			this.baseAtackPoint = baseAtackPoint;
		}else {
			this.baseAtackPoint = Setting.atackPowerLower;
		}
	}
	
	@Override
	public void outputAtackVoice() {
		if (getGender() == Setting.maleStringIndex) {
			System.out.println("「ふんっ！」");
		} else if (getGender() == Setting.femaleStringIndex) {
			System.out.println("「いくわよっ」");
		} else {
			System.out.println("「ほにゃん」");
		}

	}

}
