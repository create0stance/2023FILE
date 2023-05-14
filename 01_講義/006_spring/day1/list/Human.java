package review_obj.list;

import java.util.ArrayList;
import java.util.List;

public class Human extends Creature{
	/** ペット　 */
	private Animal pet ;
	
	/** 友達 */
	private List<Creature> friend = new ArrayList<Creature>();
	
	/**
	 * コンストラクタ
	 * @param name
	 * @param species
	 * @param runSpeed
	 */
	public Human(String name ,String species,Integer runSpeed) {
		super(name,species,runSpeed);
	}

	/**
	 * @return pet
	 */
	public Animal getPet() {
		return pet;
	}

	/**
	 * @return friend
	 */
	public List<Creature> getFriend() {
		return friend;
	}

	/**
	 * @param pet セットする pet
	 */
	public void setPet(Animal pet) {
		this.pet = pet;
	}

	/**
	 * @param friend セットする friend
	 */
	public void setFriend(List<Creature> friend) {
		this.friend = friend;
	}
}
