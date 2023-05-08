package java_sample.lesson22;

/**
 * 四足歩行で歩ける
 */
public interface FourLeggedAnimal {
	/*
	 * 定数のみフィールドに持てる
	 * = オブジェクト毎に異なる状態はインターフェイスで管理しない
	 */
	/** 足の数 */
	int LEGGED_NUM = 4;
	
	/**
	 * 歩くメソッド：抽象メソッド
	 */
	void walk();
	
	

}
