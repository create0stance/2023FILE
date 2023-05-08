package java_sample.lesson22;

public class Main {
	public static void main(String[] args) {
		
		// 犬を生成
		Dog dog = new Dog();
		// 猫を生成
		Cat cat = new Cat();
		
		dog.bark();
		dog.walk();
		
		cat.bark();
		cat.walk();
		
		BarkingAnimal[] animals = {dog,cat};
		
		for (BarkingAnimal animal : animals) {
			animal.bark();
			
			if(animal instanceof FourLeggedAnimal) {
				((FourLeggedAnimal) animal).walk();
			}
		}
	}
}
