package java_sample.lesson22_ex;

/**
 * 飛ぶインターフェイス
 *
 */
public interface Fly {
	
	/** 飛ぶ際のスピード倍率 */
	public static final int FLY_SPEED_MAGNIFICATION = 2;
	
	/**
	 * 飛ぶメソッド
	 * @param hour 飛行時間
	 * @return 飛行距離 km
	 */
	int fly(int hour);
}
