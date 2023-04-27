package review;

public class Item {
	/** itemId */
	int id;
	/** item名 */
	String name;
	/** 攻撃力 */
	int atackPower;
	/** 防御力 */
	int defensePower;
	/** 分類 */
	int type ;
	
	void showItem() {
		String desctription = "id : " + id;
		desctription += "\nアイテム名 : " + name;
		desctription += "\n攻撃力：" + atackPower;
		desctription += "\n防御力：" + defensePower;
		desctription += "\n分類：" + type;
		System.out.println(desctription);
	}
}
