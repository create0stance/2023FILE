package java_sample.lesson22_ex;

public abstract class AbstractAnimal implements BarkingAnimal{
	
	/** ライン */
	public static final String LINE = "-----------------------------------------";
	
	/** 名前 */
	protected String name;
	
	/** 種類 */
	protected String type;
	
	/** スピード(時速) */
	protected int speed;

	
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @return speed
	 */
	public int getSpeed() {
		return speed;
	}
	/**
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @param type セットする type
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @param speed セットする speed
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

}
