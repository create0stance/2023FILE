package java_sample.lesson22;

public class Dog implements FourLeggedAnimal,BarkingAnimal {
	
	@Override
	public void walk() {
		System.out.println("犬、歩きます！！");
		System.out.println("犬の足は" + LEGGED_NUM + "本です。");
	}

	@Override
	public void bark() {
		System.out.println("バウバウ！");
	}
}
