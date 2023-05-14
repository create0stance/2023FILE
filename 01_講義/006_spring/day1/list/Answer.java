package review_obj.list;

import java.util.ArrayList;
import java.util.List;

public class Answer {
	public static void main(String[] args) {

		// 1)以下の数値を格納するArrayListを作成し、拡張for文でコンソール出力せよ
		// 100,200,300,400
		// ※変数名等の指定は無し。
		// 出力例）100,200,300,400,
		List<Integer> nums = new ArrayList<Integer>();

		nums.add(100);
		nums.add(200);
		nums.add(300);
		nums.add(400);

		for (Integer num : nums) {
			System.out.print(num + ",");
		}

		// 2)以下animalsリストをループ処理し、以下をコンソールに出力せよ
		// タロくん(柴犬)は時速32kmで走ります。
		// グレちゃん(グレイハウンド)は時速70kmで走ります。
		// 	黒ちゃん(チーター)は時速110kmで走ります。
		System.out.println("\n----------------------------------------");
		List<Animal> animals = new ArrayList<Animal>();
		animals.add(new Animal("タロくん", "柴犬", 32));
		animals.add(new Animal("グレちゃん", "グレイハウンド", 70));
		animals.add(new Animal("黒ちゃん", "チーター", 110));

		// ↓2)のループ処理を記述
		for (Creature animal : animals) {
			System.out.print(animal.getName() + "(");
			System.out.print(animal.getSpecies() + ")は時速");
			System.out.println(animal.getRunSpeed() + "kmで走ります。");
		}

		//3)以下のhumansリストをループ処理し、以下をコンソール出力せよ
		/*
		----------------------------------------
		1人目の人間情報を表示します。
		種別：日本人
		名前：山本太郎
		時速：36km
		----------------------------------------
		2人目の人間情報を表示します。
		種別：アメリカ人
		名前：スティーブ
		時速：37km
		 */
		List<Human> humans = new ArrayList<Human>();
		humans.add(new Human("山本太郎", "日本人", 36));
		humans.add(new Human("スティーブ", "アメリカ人", 37));

		// ↓3のループ処理を記述
		for (int i = 0; i < humans.size(); i++) {
			System.out.println("----------------------------------------");
			System.out.println(i + 1 + "人目の人間情報を表示します。");
			System.out.println(humans.get(i));
		}

		//4)humansリストをループ処理し、以下をコンソール出力せよ。
		// 山本太郎のペットはタロくん(柴犬)です。
		// スティーブのペットはグレちゃん(グレイハウンド)です。
		System.out.println("----------------------------------------");
		humans.get(0).setPet(animals.get(0));
		humans.get(1).setPet(animals.get(1));
		
		// ↓4)のループ処理を記述
		for (Human human : humans) {
			Animal pet = human.getPet();
			System.out.println(human.getName() + "のペットは" + pet.getName() + "(" + pet.getSpecies() + ")です。");
		}
		System.out.println("----------------------------------------");

		// 5)humansリストをループ処理し、以下をコンソール出力せよ。
		/*		山本太郎さんの友達を紹介します。
				種別：柴犬
				名前：タロくん
				時速：32km
				-----------------------------------------------
				種別：グレイハウンド
				名前：グレちゃん
				時速：70km
				-----------------------------------------------
				種別：チーター
				名前：黒ちゃん
				時速：110km
				-----------------------------------------------
				種別：アメリカ人
				名前：スティーブ
				時速：37km
				-----------------------------------------------
				スティーブさんの友達を紹介します。
				友達はいません！
		*/

		// 友達リストを作成
		List<Creature> creatures = new ArrayList<>();
		// 動物を全て友達リストに追加
		for (Animal animal : animals) {
			creatures.add(animal);
		}
		// スティーブを友達リストに追加
		creatures.add(humans.get(1));
		// 山本さんに友達リストをセット
		humans.get(0).setFriend(creatures);

		// ↓5)のループ処理記述箇所
		for (Human human : humans) {
			System.out.println(human.getName() + "さんの友達を紹介します。");
			
			for (Creature friend : human.getFriend()) {
				System.out.println(friend);
				System.out.println("-----------------------------------------------");
			}
			
			if (human.getFriend().size() < 1) {
				System.out.println("友達はいません！");
			}
		}
	}

}
