package java_sample.lesson21;

/**
 * 
 * 動物抽象クラス
 *
 */
public abstract class Animal {
	
	
	/**
	 * 鳴くメソッド：抽象メソッド
	 */
	abstract void bark();
	
	/**
	 * 挨拶をする：具象メソッド
	 */
	public void greet() {
		System.out.println("よろしくお願いします！");
	}
}
