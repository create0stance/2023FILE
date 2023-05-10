package java_sample.lesson22_sumple;
/**
 * 鳴く動物インターフェイス
 */
public interface BarkingAnimal {
	
	/** 抽象メソッド */
	void bark();
	
	/** デフォルトメソッド	 */
	public default void barkInfomation() {
		System.out.println("「今から鳴きますね！」");
	}
	
	/** クラスメソッド */
	public static void test() {
		
	}
}
