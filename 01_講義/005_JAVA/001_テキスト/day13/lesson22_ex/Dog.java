package java_sample.lesson22_ex;

/**
 * 歩ける、鳴ける、犬クラス
 *
 */
public class Dog extends AbstractAnimal implements FourLeggedAnimal {
	
	@Override
	public void walk() {
		System.out.println("犬、歩きます！！");
		System.out.println(getName() + "("+ getType() +")は" + "適当に歩きました。");
	}

	@Override
	public int walk(int walkingHour) {
		System.out.println("犬、"+walkingHour+"時間、歩きます！！");
		// 移動距離
		int movingDistance = walkingHour * speed;
		System.out.println(getName() + "("+ getType() +")は" + movingDistance + "km歩きました。");
		return movingDistance;
	}

	
	@Override
	public void bark() {
		System.out.println(AbstractAnimal.LINE);
		System.out.println("バウバウ！");
	}
}
