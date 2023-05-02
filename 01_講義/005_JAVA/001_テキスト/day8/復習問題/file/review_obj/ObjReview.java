package review_obj;

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

		// プレイヤーを二人作成するためのループ
		for (int i = 0; i < 2; i++) {
			
			// プレイヤーID
			int playerId = i + 1;

			// 作成開始
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
			
			// Characterオブジェクトを生成し変数playerに代入せよ。
			Character player = new Character();
			
			// ③追記			
			// playerのidフィールド,nameフィールド、genderフィールドに値をセットせよ。
			// id : ループ回数+1
			// name : ユーザー入力値
			// gender：ユーザー入力値

			//	④追記
			// Characterクラスの引数なしsetBaseHp()メソッド、setBaseAtackPoint()を実行し、それぞれのフィールドにランダム値をセットせよ。

			// 作成したCharacterを配列に追加
			characters[i] = player;
			
			System.out.println(topLine);
			//⑤追記

		}
		// 作成したプレイヤー情報を表示
		System.out.println(bottomLine);
		System.out.println(infomator+" > 以下のPlayerが作成されました");
		System.out.println(topLine);

		// ⑥追記
		
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
