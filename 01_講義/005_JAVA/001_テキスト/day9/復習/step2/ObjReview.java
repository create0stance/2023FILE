package review_obj.step2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ObjReview {
public static void main(String[] args) throws IOException {
		
		// 整形用文字列
		String centerLine = "-----------------------------------------";
		String bottomLine = "＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿";
		String topLine = "￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣";
		String infomator = "(･8･)";
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		// Character要素を2つ持つ配列を用意
		Character[] characters = new Character[2];

		// プレイヤーを二人作成するためにループ
		for (int i = 0; i < 2; i++) {
			// プレイヤーID
			int playerId = i + 1;

			System.out.println(bottomLine);
			System.out.println(infomator+" ＜ プレイヤー" + playerId + "を作成します。");
			System.out.println(topLine);

			// プレイヤー名入力
			System.out.print("1) プレイヤー名を入力してください。\n>");
			String name = reader.readLine();
			System.out.println(topLine);
			
			// 性別選択
			System.out.print("2) 性別を選択してください。\n1:男性\n2:女性\n3:その他\n>");
			int gender = Integer.parseInt(reader.readLine());
			
			// キャラクターオブジェクトの生成
			Character player = new Character(playerId,name,gender);
			player.setBaseHp(Character.calcDefaultBaseHp(player.getGender()));
			player.setBaseAtackPoint(Character.calcDefaultBaseAtackPower(player.getGender()));

			characters[i] = player;
			
			System.out.println(topLine);
			System.out.println("Player" + playerId + "「" + player.getName() + "」を作成しました。");
			System.out.println("性別は「" + Character.getGendeWithString(player.getGender()) + "」です。");

		}
		// 作成したプレイヤー情報を表示
		System.out.println(bottomLine);
		System.out.println(infomator+" > 以下のPlayerが作成されました");
		System.out.println(topLine);

		for (Character character : characters) {
			character.showInfomation();
			System.out.println(centerLine);
		}
	}

}
