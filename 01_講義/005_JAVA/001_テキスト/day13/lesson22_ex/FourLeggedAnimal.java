package java_sample.lesson22_ex;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 四足歩行で歩けるインターフェイス
 */
public interface FourLeggedAnimal {
	/*
	 * 定数のみフィールドに持てる
	 * = オブジェクト毎に異なる状態はインターフェイスで管理しない
	 */
	int LEGGED_NUM = 4;
//	public static final int LEGGED_NUM = 4;
	
	/** バッファードリーダー */
	public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	/**
	 * 歩くメソッド：抽象メソッド
	 */
	void walk();
	
	/**
	 * 歩くメソッド：指定した時間で歩ける距離をリターン
	 * @param walkingHour 歩く時間
	 * @return 歩ける距離
	 */
	int walk(int walkingHour);
	
	/**
	 * 何時間歩くか聞くメソッド
	 * @return 入力された時間
	 */
	public static int listenWalkingHour() {
		System.out.print("何時間、歩きましょう？\n>");
		
		// 入力を受け付け数値をリターンする
		// try catchは一回分からなくてもスルーでOK
		try {
			return Integer.parseInt(reader.readLine());
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	

}
