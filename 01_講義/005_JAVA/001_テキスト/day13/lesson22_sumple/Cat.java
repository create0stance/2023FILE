package java_sample.lesson22_sumple;

public class Cat extends AbstractAnimal 
	implements FourLeggedAnimal{

	public Cat(String name) {
		super(name);
	}

	@Override
	public void walk() {
		System.out.println(name + "(猫)歩きます！！");
	}
	
	@Override
	public void bark() {
		super.bark();
		System.out.println("にゃーにゃー");
	}

}
