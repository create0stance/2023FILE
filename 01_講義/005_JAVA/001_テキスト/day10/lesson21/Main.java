package java_sample.lesson21;

public class Main {
	public static void main(String[] args) {
		
		Animal lion = new Lion();
		Animal pigeon = new Pigeon();
		
		lion.bark();
		lion.greet();
		
		pigeon.bark();
		pigeon.greet();
		
		/*
		 * 抽象クラスのメリット：
		 * １，具象クラスは、必ず抽象メソッドを実装している保証がある。
		 * ２，スーパークラスで各々の具体的な処理を考える必要がない。
		 * ３，スーパークラスの型でまとめて扱うことが出来る。
		 */
		Animal[] animalArray = {lion,pigeon};
		
		for (Animal animal : animalArray) {
			animal.bark();
			animal.greet();
		}
	}

}
