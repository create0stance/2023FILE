package review_obj.step3_answer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException, InterruptedException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		// Character要素を2つ持つ配列を用意
		Character[] characters = new Character[2];

		// プレイヤーを二人作成するためにループ
		for (int i = 0; i < 2; i++) {
			// プレイヤーID
			int playerId = i + 1;

			System.out.println(Constant.BOTTOM_LINE);
			System.out.println(Constant.INFOMATOR + " ＜ プレイヤー" + playerId + "を作成します。");
			System.out.println(Constant.TOP_LINE);

			// プレイヤー名入力
			System.out.print("1) プレイヤー名を入力してください。\n>");
			String name = reader.readLine();
			System.out.println(Constant.TOP_LINE);

			// 性別選択
			System.out.print("2) 性別を選択してください。\n1:男性\n2:女性\n3:その他\n>");
			String inputGender = Common.regexpCheck("^[0-9]{1}$",reader.readLine().substring(0,1),"0"); 
			int gender = Integer.parseInt(inputGender);

			// キャラクター作成
			Character player = new Character(playerId, name, gender);
			
			// 配列にセット
			characters[i] = player;

			System.out.println(Constant.TOP_LINE);
			System.out.println("Player" + playerId + "「" + player.getName() + "」を作成しました。");
			System.out.println("性別は「" + Character.getGendeWithString(player.getGender()) + "」です。");

		}
		// 作成したプレイヤー情報を表示
		System.out.println(Constant.BOTTOM_LINE);
		System.out.println(Constant.INFOMATOR + " > 以下のPlayerが作成されました");
		System.out.println(Constant.TOP_LINE);

		for (Character character : characters) {
			character.showInfomation();
			System.out.println(Constant.CENTER_LINE);
		}

		System.out.print(Constant.INFOMATOR + " ＜ バトルを開始しますか？(1:する)\n>");
		int doBattle = Integer.parseInt(reader.readLine());

		if (doBattle == 1) {
			
			//バトルを行い勝者を取得
			Character winner = BattleManager.characterBattleStart(characters[0], characters[1]);

			Reader readerPlayer = new Reader(winner.getId(), winner.getName(), winner.getGender());
			readerPlayer.setBaseAtackPoint(winner.getBaseAtackPoint() * 2);
			readerPlayer.setBaseHp(winner.getBaseHp() * 2);
			System.out.println("勝者は、" + readerPlayer.getName() + "です！");
			System.out.println(readerPlayer.getName() + "はステータスが2倍になりました！");
			System.out.println(Constant.BOTTOM_LINE);
			System.out.println("変更前");
			System.out.println(Constant.TOP_LINE);
			winner.showInfomation();
			System.out.println(Constant.BOTTOM_LINE);
			System.out.println("変更後");
			System.out.println(Constant.TOP_LINE);
			readerPlayer.showInfomation();
		}
	}

}
