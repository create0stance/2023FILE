package review_obj.step2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * メインクラス
 * 
 */
public class Main {
	
	/** 整形用　中央線 */
	public static String centerLine = "-----------------------------------------";
	
	/** 整形用　下線 */
	public static String bottomLine = "＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿";
	
	/** 整形用　上線 */
	public static String topLine = "￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣";
	
	/** 案内者アイコン */
	public static String infomator = "(･8･)";
	
	/**
	 * メインメソッド
	 * @param args
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws IOException, InterruptedException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		// Character要素を2つ持つ配列を用意
		Character[] characters = new Character[2];

		// プレイヤーを二人作成するためにループ
		for (int i = 0; i < 2; i++) {
			// プレイヤーID
			int playerId = i + 1;

			System.out.println(bottomLine);
			System.out.println(infomator + " ＜ プレイヤー" + playerId + "を作成します。");
			System.out.println(topLine);

			// プレイヤー名入力
			System.out.print("1) プレイヤー名を入力してください。\n>");
			String name = reader.readLine();
			System.out.println(topLine);

			// 性別選択
			System.out.print("2) 性別を選択してください。\n1:男性\n2:女性\n3:その他\n>");
			int gender = Integer.parseInt(reader.readLine());

			// ★2_3)キャラクター作成
			Character player = new Character();
			player.setId(playerId);
			player.setName(name);
			player.setGender(gender);
			// ★1_2)
			player.setBaseHp();
			player.setBaseAtackPoint();
			
			// 配列にセット
			characters[i] = player;

			System.out.println(topLine);
			System.out.println("Player" + playerId + "「" + player.getName() + "」を作成しました。");
			System.out.println("性別は「" + player.getGendeWithString(player.getGender()) + "」です。");

		}
		// 作成したプレイヤー情報を表示
		System.out.println(bottomLine);
		System.out.println(infomator + " > 以下のPlayerが作成されました");
		System.out.println(topLine);

		for (Character character : characters) {
			character.showInfomation();
			System.out.println(centerLine);
		}

		// バトル処理開始
		System.out.print(infomator + " ＜ バトルを開始しますか？(1:する)\n>");
		int doBattle = Integer.parseInt(reader.readLine());

		if (doBattle == 1) {

			//バトルを行い勝者を取得
			Character winner = BattleManager.characterBattleStart(characters[0], characters[1]);

			System.out.println("勝者は、" + winner.getName() + "です！");
		}
	}

}
