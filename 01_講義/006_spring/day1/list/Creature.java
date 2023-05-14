package review_obj.list;

public class Creature {
	
	/** 名前 */
	private String name ;
	
	/** 種族 */
	private String  species;
	
	/** 走る時速 */
	private Integer runSpeed;
	
	/**
	 * コンストラクタ
	 * @param name
	 * @param species
	 * @param runSpeed
	 */
	public Creature(String name ,String species,Integer runSpeed) {
		this.name = name;
		this.species = species;
		this.runSpeed = runSpeed;
	}
	
	/**
	 * 指定時間での移動距離をリターン
	 * @param hour 指定時間
	 * @return 移動距離(km)
	 */
	public Double calcMovingDistance(Double hour) {
		return hour * getRunSpeed();
	}
	
	@Override
	public String toString() {
		String str = "種別：" + getSpecies();
		str += "\n名前：" + getName();
		str += "\n時速：" + getRunSpeed() + "km";
		return str;
	}
	
	/**
	 * 名前をリターン
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 走る時速をリターン
	 * @return runSpeed
	 */
	public Integer getRunSpeed() {
		return runSpeed;
	}
	
	/**
	 * 種族をリターン
	 * @return species
	 */
	public String getSpecies() {
		return species;
	}
	/**
	 * 名前をセットする
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 時速をセットする
	 * @param runSpeed セットする runSpeed
	 */
	public void setRunSpeed(Integer runSpeed) {
		this.runSpeed = runSpeed;
	}

	/**
	 * 種族をセットする
	 * @param species セットする種族
	 */
	public void setSpecies(String species) {
		this.species = species;
	}
}
