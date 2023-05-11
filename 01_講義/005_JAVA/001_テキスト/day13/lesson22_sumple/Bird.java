package java_sample.lesson22_sumple;

public class Bird extends AbstractAnimal{

	/** コンストラクタ */
	public Bird(String name) {
		super(name);
	}

	@Override
	public void bark() {
		super.bark();
		System.out.println("ギャーギャー！");
		
	}

}
