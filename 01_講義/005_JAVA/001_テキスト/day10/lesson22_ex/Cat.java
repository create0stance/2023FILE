package java_sample.lesson22_ex;

public class Cat extends AbstractAnimal implements FourLeggedAnimal,Fly{

	@Override
	public void walk() {
		System.out.println("猫、歩きます！！");
		System.out.println(getName() + "("+ getType() +")は" + "適当に歩きました。");
	}

	@Override
	public int walk(int walkingHour) {
		System.out.println("猫、"+walkingHour+"時間、歩きます！！");
		// 移動距離
		int movingDistance = walkingHour * speed;
		System.out.println(getName() + "("+ getType() +")は" + movingDistance + "km歩きました。");
		return movingDistance;
	}

	@Override
	public void bark() {
		System.out.println(AbstractAnimal.LINE);
		System.out.println("にゃーにゃー");
	}

	@Override
	public int fly(int hour) {
		System.out.println("猫、"+hour+"時間、飛びます！！");
		// 移動距離
		int movingDistance = hour * speed * FLY_SPEED_MAGNIFICATION;
		System.out.println(getName() + "("+ getType() +")は" + movingDistance + "km、飛びました。");
		return movingDistance;
	}

	

}
