package java_sample.lesson13;

public class Pojo {
	/*
	 * id		商品名		カテゴリID		カテゴリ名		在庫
	 * 1		あんパン		1				菓子パン		100
	 * 2		カレーパン		2				惣菜パン		0
	 * 3		メロンパン		1				菓子パン		0
	 */
	public static void main(String[] args) {
		// 配列でデータの集合を扱う
		String[][] items = new String[3][4];

		// あんパンを設定
		String[] item = new String[4];
		item[0] = "1";
		item[1] = "あんパン";
		item[2] = "1";
		item[3] = "菓子パン";
		items[0] = item;

		// あんパンを設定
		String[] item2 = new String[4];
		item2[0] = "2";
		item2[1] = "カレーパン";
		item2[2] = "2";
		item2[3] = "惣菜パン";
		items[1] = item2;

		// あんパンを設定
		String[] item3 = new String[4];
		item3[0] = "3";
		item3[1] = "メロンパン";
		item3[2] = "3";
		item3[3] = "菓子パン";
		items[2] = item3;
		
		for (String[] value  : items) {
			String str = "id\t\t" + Integer.parseInt(value[0]);
			str += "\n商品名\t\t" + value[1];
			str += "\nカテゴリID\t\t" + Integer.parseInt(value[2]);
			str += "\nカテゴリ名\t\t" + value[3];
			str += "\n-------------------------------";
			System.out.println(str);
		}
		
		// オブジェクトでデータの集合を扱う
		class Item {
			// フィールドで情報を保持する
			int id ;
			String name;
			int catId;
			String catName;
			int stock;
			
			/**
			 * 在庫がない場合アラートを発生させる
			 */
			void stockAlert() {
				if(stock < 1) {
					System.out.println("[Alert]在庫がありません！！");
				}
			}
		}
		
		Item[] itemObjs = new Item[3];
		
		Item itemObj = new Item();
		itemObj.id = 1;
		itemObj.name = "あんパン";
		itemObj.catId = 1;
		itemObj.catName = "菓子パン";
		itemObj.stock = 100;
		
		Item itemObj2 = new Item();
		itemObj2.id = 2;
		itemObj2.name = "カレーパン";
		itemObj2.catId = 2;
		itemObj2.catName = "惣菜パン";
		
		Item itemObj3 = new Item();
		itemObj3.id = 3;
		itemObj3.name = "メロンパン";
		itemObj3.catId = 1;
		itemObj3.catName = "菓子パン";
		
		itemObjs[0] = itemObj;
		itemObjs[1] = itemObj2;
		itemObjs[2] = itemObj3;
		
		for (Item iObj : itemObjs) {
			String str = "id\t\t" + iObj.id;
			str += "\n商品名\t\t" + iObj.name;
			str += "\nカテゴリID\t\t" + iObj.catId;
			str += "\nカテゴリ名\t\t" + iObj.catName;
			str += "\n在庫\t\t" + iObj.stock;
			str += "\n-------------------------------";
			iObj.stockAlert();
			System.out.println(str);
			
		}
	}
}
