package java_sample.lesson22_sumple;

public abstract class AbstractAnimal implements BarkingAnimal{
	
	String name;
	
	public AbstractAnimal(String name) {
		this.name = name;
		System.out.println(name + "です。");
	}
	
	@Override
	public void bark() {
		barkInfomation();
	}

}
