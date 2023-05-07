package review_obj.step2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * バトル管理者クラス
 *
 */
public class BattleManager {
	
	/** 整形用　でこぼこ線 */
	public static String bumpLine = "＼／＼／＼／＼／＼／＼／＼／＼／＼／＼";
	
	/** バトル案内者 */
	public static String battleInfomator = "(U・ᴥ・U)";
	
	/** 整形用　下線 */
	public static String bottomLine = "＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿";
	
	/** 整形用　上線 */
	public static String topLine = "￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣";
	
	/**
	 * キャラクター2人をバトルさせ、勝者をリターン
	 * @param c1 バトルするキャラクター
	 * @param c2 バトルするキャラクター
	 * @return 勝者
	 * @throws IOException 
	 */
	public static Character characterBattleStart(Character c1,Character c2) throws IOException{
		// バトル開始の案内
		battleStartInfomation(c1,c2);
		
		// TODO バトル処理が分からないので放置中。。。
		
		// 3_1)お好きな形でバトル処理を書いてください！
		// 勝者としてCharacterを返してもらえれば、どんな処理でも多分大丈夫！
		// 独自のロジックを考えて、共有しようー！
		
		Character winner = c1;
		// 勝者をリターン
		return winner;
	}
	
	/**
	 * バトル開始の案内文をコンソールに出力
	 * @param c1 バトルするキャラクター
	 * @param c2 バトルするキャラクター
	 * @throws IOException
	 */
	private static void battleStartInfomation(Character c1,Character c2) throws IOException {
		System.out.println(bottomLine);
		System.out.print(battleInfomator + " > ");
		System.out.println(c1.getName() + "と、"+c2.getName() + "が、バトルを開始したワン！");
		System.out.println("　　　　　　 > Enterでバトルは進行するワン！");
		System.out.println(topLine);
		System.out.println(c1.getName() + "\t\t攻：" + c1.getBaseAtackPoint() + "\t\tHP:" + c1.getBaseHp() );
		System.out.println(c2.getName() + "\t\t攻：" + c2.getBaseAtackPoint() + "\t\tHP:" + c2.getBaseHp() );
		System.out.println(bottomLine);
		// Enterが押下されるまで処理をストップ
		battleSleep();
	}
	
	/**
	 * 攻撃ごとのストップ処理
	 * @throws IOException 
	 */
	private static void battleSleep() throws IOException {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));	
			System.out.print("next >");
			// enterが押下されるまで処理を止める
			reader.read();
			System.out.println(topLine);
	}
}
