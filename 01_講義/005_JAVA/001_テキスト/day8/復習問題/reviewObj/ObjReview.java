package reviewObj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ObjReview {
	public static void main(String[] args) throws IOException {
		String line = "=================================";
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		// ①Characterクラスを作成し、以下のフィールドとメソッドを作成せよ
		//		[フィールド]
		//			
		// Character要素を2つ持つ配列を用意
		Character[] characters = new Character[2];

		for (int i = 0; i < 2; i++) {

			System.out.println("プレイヤー" + (i + 1) + "を作成します。");
			System.out.println(line);
			
			// キャラクターオブジェクトを生成し、変数playerに代入しよう。
			Character player = new Character();

			System.out.print("プレイヤー名を入力してください。\n>");
			String name = reader.readLine();
			player.setName(name);

			System.out.print("性別を選択してください。\n1:男性\n2:女性\n>");
			int gender = Integer.parseInt(reader.readLine());
			player.setGender(gender);

			player.setHp();
			player.setBaseAtackPoint();

			characters[i] = player;
			
			System.out.println(line);
			System.out.println("Player" + (i + 1) + "「" + player.getName() + "」を作成しました。");
			System.out.println("性別は「" + player.getGendeWithString() + "」です。");
			System.out.println(line);

		}
		
		System.out.println("作成したPlayer情報は以下となります。");
		System.out.println(line);

		for (Character character : characters) {
			character.showInfomation();
			System.out.println(line);
		}
		/*
		 * A:4110
		 * B:6945
		 * C:5760
		 * D:7992
		 * E:6840
		 * F:5285
		 * */

	}
/*
プレイヤー1を作成します。
=================================
プレイヤー名を入力してください。
>ちゃむ
性別を選択してください。
1:男性
2:女性
>2
=================================
Player1「ちゃむ」を作成しました。
性別は「女性」です。
=================================
プレイヤー2を作成します。
=================================
プレイヤー名を入力してください。
>たむ
性別を選択してください。
1:男性
2:女性
>1
=================================
Player2「たむ」を作成しました。
性別は「男性」です。
=================================
作成したPlayer情報は以下となります。
=================================
プレイヤー名：ちゃむ
性別：女性
HP：2244
攻撃力：427
=================================
プレイヤー名：たむ
性別：男性
HP：2764
攻撃力：777
=================================
 */
	
}
