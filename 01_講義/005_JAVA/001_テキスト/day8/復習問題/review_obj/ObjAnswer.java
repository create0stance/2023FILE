package review_obj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ObjAnswer {
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
			Character player = new Character();
			player.setId(playerId);
			player.setName(name);
			player.setGender(gender);
			player.setHp();
			player.setBaseAtackPoint();

			characters[i] = player;
			
			System.out.println(topLine);
			System.out.println("Player" + playerId + "「" + player.getName() + "」を作成しました。");
			System.out.println("性別は「" + player.getGendeWithString() + "」です。");

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
/*
＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿
(･8･) ＜ プレイヤー1を作成します。
￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣
1) プレイヤー名を入力してください。
>ちゃむ
￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣
2) 性別を選択してください。
1:男性
2:女性
3:その他
>2
￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣
Player1「ちゃむ」を作成しました。
性別は「女性」です。
＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿
(･8･) ＜ プレイヤー2を作成します。
￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣
1) プレイヤー名を入力してください。
>たむ
￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣
2) 性別を選択してください。
1:男性
2:女性
3:その他
>1
￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣
Player2「たむ」を作成しました。
性別は「男性」です。
＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿
(･8･) > 以下のPlayerが作成されました
￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣
ID：1
プレイヤー名：ちゃむ
性別：女性
HP：1880
攻撃力：335
-----------------------------------------
ID：2
プレイヤー名：たむ
性別：男性
HP：2591
攻撃力：994
-----------------------------------------
 */
/*
 性別0～3以外の数値入力時
＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿
(･8･) ＜ プレイヤー1を作成します。
￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣
1) プレイヤー名を入力してください。
>ちゃむ
￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣
2) 性別を選択してください。
1:男性
2:女性
3:その他
>4
￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣
Player1「ちゃむ」を作成しました。
性別は「未選択」です。
 */
	
}
