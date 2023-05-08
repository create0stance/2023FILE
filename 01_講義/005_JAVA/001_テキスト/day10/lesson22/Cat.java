package java_sample.lesson22;

public class Cat implements FourLeggedAnimal,BarkingAnimal{

	@Override
	public void walk() {
		System.out.println("猫、歩きます！！");
	}
	
	@Override
	public void bark() {
		System.out.println("にゃーにゃー");
	}

}
