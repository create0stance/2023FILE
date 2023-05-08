package java_sample.lesson22_ex;
/**
 * 
 * 
 */
public interface BarkingAnimal {
	void bark();
	
	public default void barkInfomation() {
		System.out.println("「今から鳴きますね！」");
	}
	
	public static void test() {
		
	}
}
