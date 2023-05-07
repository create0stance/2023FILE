package review_obj.step3_answer;

public class Reader extends Character {

	public Reader(int id, String name, int gender) {
		super(id, name, gender);
	}
	
	@Override
	public void setBaseHp(int baseHp){
		if(baseHp >= Constant.HP_LOWER && baseHp <= Constant.HP_UPPER*2) {
			this.baseHp = baseHp;
		}else {
			this.baseHp = Constant.HP_LOWER;
		}
	}

	/**
	 * 基礎攻撃力をセット
	 * @param baseAtackPoint セットする基礎攻撃力
	 */
	@Override
	public void setBaseAtackPoint(int baseAtackPoint) {
		if(baseAtackPoint >= Constant.ATACK_POWER_LOWER && baseAtackPoint <= Constant.ATACK_POWER_UPAER * 2) {			
			this.baseAtackPoint = baseAtackPoint;
		}else {
			this.baseAtackPoint = Constant.ATACK_POWER_LOWER;
		}
	}

}
