package java_sample.lesson17;

public class Main {
	public static void main(String[] args) {
		// Dogオブジェクトを変数dogに代入
		Dog dog = new Dog();
		// Dogクラスのshowメソッドを呼び出す
		dog.show();
		
		// 2体目Dogを生成
		Dog dog2 = new Dog("オス");
		dog2.show();
		
		

	}
}
