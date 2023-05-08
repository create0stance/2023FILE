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

		AbstractAnimal[] animals = {dog,cat};
		
		for (AbstractAnimal animal : animals) {
			animal.bark();
			int hour = 0;
			if(animal instanceof FourLeggedAnimal) {
				System.out.println(animal.getName() + "は、4足歩行可能です。");
				// 歩く時間を聞く
				hour = FourLeggedAnimal.listenWalkingHour();
				((FourLeggedAnimal) animal).walk(hour);
			}
			
			if(animal instanceof Fly) {
				System.out.println(AbstractAnimal.LINE);
				System.out.println(animal.getName() + "は、飛べます！");
				((Fly) animal).fly(hour);
			}
		}
	}
}
