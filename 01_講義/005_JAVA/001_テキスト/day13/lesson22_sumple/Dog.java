package java_sample.lesson22_sumple;

public class Dog extends AbstractAnimal implements FourLeggedAnimal {
	
	public Dog(String name) {
		super(name);
	}

	@Override
	public void walk() {
		System.out.println(name + "(犬)、歩きます！！");
		System.out.println("犬の足は" + LEGGED_NUM + "本です。");
	}

	@Override
	public void bark() {
		super.bark();
		System.out.println("バウバウ！");
	}
}
