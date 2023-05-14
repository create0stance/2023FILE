package review_obj.list;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * コレクションフレームワーク復習問題
 * ★ArrayListはspringでも利用頻度が高いので、慣れておこう！
 */
public class Main {
	public static void main(String[] args) {

		// 1)以下の数値を格納するArrayListを作成し、拡張for文でコンソール出力せよ
		// 100,200,300,400
		// ※変数名等の指定は無し。
		// 出力例）100,200,300,400,

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

		//4)humansリストをループ処理し、以下をコンソール出力せよ。
		// 山本太郎のペットはタロくん(柴犬)です。
		// スティーブのペットはグレちゃん(グレイハウンド)です。
		System.out.println("----------------------------------------");
		humans.get(0).setPet(animals.get(0));
		humans.get(1).setPet(animals.get(1));

		// ↓4)のループ処理を記述

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

		// 6)【応用】streamApiを使ってみよう！streamApiはよく使うから余裕があれば検索し、挑戦してみよう。
		// humansリストから、名前が山本太郎のオブジェクトのみ抽出
		String searchName = "山本太郎";
		List<Human> filteredHumans = humans.stream().filter(human -> human.getName().equals(searchName))
				.collect(Collectors.toList());

		// 絞り込んだリストが空じゃない、かつ、1つ目の要素の友達リストが空じゃない場合の処理
		if (filteredHumans.size() > 0 && filteredHumans.get(0).getFriend().size() > 0) {
			// 山本さんの友達リストを取得
			List<Creature> yamamotosFriends = filteredHumans.get(0).getFriend();
			System.out.println("-----------------------------------------------");
			System.out.println(searchName + "さんの友達で1番早いのは、以下の友達です！");
			System.out.println("-----------------------------------------------");
			// 6)【問題】山本さんの友達リストの中で、時速の数値が1番大きな生物を取得し、以下をコンソール出力せよ。
			/*
			 種別：チーター
			 名前：黒ちゃん
			 時速：110km
			*/
			// ↓6)以下に処理を記述
			// maxを使いrunSpeedが一番大きな生物を取得
			
		}
	}

}
