package java_sample.lesson22_ex;

public class Main {
	public static void main(String[] args) {
		
		Dog dog = new Dog();
		// 犬の情報をセット
		dog.setName("ポチ");
		dog.setType("柴犬");
		dog.setSpeed(17);
		
		Cat cat = new Cat();
		cat.setName("タマ");
		cat.setType("三毛猫");
		cat.setSpeed(19);

		// 配列の作成
		AbstractAnimal[] animals = {dog,cat};
		
		// 配列をループ
		for (AbstractAnimal animal : animals) {
			
			// AbstractAnimalはBarkingAnimalインターフェイスを継承している
			// ので、必ず鳴ける。
			animal.bark();
			
			// 移動時間を初期化
			int movingHour = 0;
			
			// Object instanceof クラス名
			// オブジェクトが指定したクラス名の
			// オブジェクトか判定。
			if(animal instanceof FourLeggedAnimal) {
				System.out.println(animal.getName() + "は、4足歩行可能です。");
				
				// ★FourLeggedAnimalインターフェイスの実装クラスなら、
				// listenWalkingHour()メソッドを実行できる。
				
				// 歩く時間を聞く
				movingHour = FourLeggedAnimal.listenWalkingHour();
				// walkメソッドも実行できる
				// ダウンキャストし、独自処理を実行
				((FourLeggedAnimal) animal).walk(movingHour);
			}
			
			// Flyオブジェクトなら飛べる
			if(animal instanceof Fly) {
				System.out.println(AbstractAnimal.LINE);
				System.out.println(animal.getName() + "は、飛べます！");
				((Fly) animal).fly(movingHour);
			}
		}
	}
}
