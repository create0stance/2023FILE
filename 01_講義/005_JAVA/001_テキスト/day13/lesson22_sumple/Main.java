package java_sample.lesson22_sumple;
// c,e,a,b,d
public class Main {
	public static void main(String[] args) {
		
		// 犬を生成
		Dog dog = new Dog("ポチ");
		// 猫を生成
		Cat cat = new Cat("タマ");
		// 鳥を生成
		Bird bird = new Bird("ぴよ太郎");
		
		System.out.println("==============================");
		
		// 配列の生成
		AbstractAnimal[] animals = {dog,cat,bird};
		
		// ループ処理する
		for (AbstractAnimal animal : animals) {
			
			// FourLeggedAnimalオブジェクトであれば
			// 歩く！
			if(animal instanceof FourLeggedAnimal) {
				// キャストして独自の処理を実行
				((FourLeggedAnimal) animal).walk();
			}
			//鳴く
			animal.bark();
			
			System.out.println("======================");
		}
	}
}
