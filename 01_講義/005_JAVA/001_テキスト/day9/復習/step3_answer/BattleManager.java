package review_obj.step3_answer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * バトル管理者クラス
 *
 */
public class BattleManager {
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
		
		// キャラクターのHPを直接変更しない様に、変数に代入
		int c1Hp = c1.getBaseHp();
		int c2Hp = c2.getBaseHp();
		
		//どちらかのHPが0になるまで、バトルを繰り返す
		while(true) {
			
			// 攻撃側と防御側を入れ替え、順番にバトル
			if((c2Hp = battle(c1,c2)) < 1 || (c1Hp = battle(c2,c1)) < 1) {
				break;
			}
		}
		
		// 残HPが残っているキャラクターを勝者にセット
		Character winner = c1Hp > 0 ? c1 : c2;
		
		// 勝者をリターン
		return winner;
	}

	/**
	 * バトル処理
	 * @param atacker 攻撃者
	 * @param defender 防御者
	 * @return 防御者の残HP
	 * @throws IOException
	 */
	private static int battle(Character atacker,Character defender) throws IOException {

		// 防御者のHPを変数に代入
		int defenderHp = defender.getBaseHp();
		
		// 0.0~1.0のランダム値を取得し、攻撃力倍率に設定
		double atackPowerRate = Math.random();
		// 攻撃力倍率が、0.8より高い場合、攻撃力倍率を10倍に上書き
		atackPowerRate = atackPowerRate > 0.8 ? 10 : atackPowerRate;
		
		// 攻撃力を決定
		int atackPoint = (int)(atacker.getBaseAtackPoint() * atackPowerRate);
		
		// 防御者のHPを減算
		defenderHp = defenderHp - atackPoint;
		
		// 結果をアナウンス
		System.out.println(Constant.BATTLE_INFOMATOR + " < "+ atacker.getName() + "の攻撃だワン");
		System.out.println(Constant.BUMP_LINE);
		// 会心の一撃の場合、出力内容を変更する
		String atackText =  atackPowerRate == 10 ? "会心の一撃が炸裂！！\n（＊｀Д´）＝Э）TДT●）" : (int)(atackPowerRate*100) + "%の力で攻撃した！";
		
		System.out.println(atackText);
		System.out.println(atackPoint + "の攻撃！");
		if(defenderHp > 0) {			
			System.out.println(defender.getName() + "の体力は残り" + defenderHp + "！");
		}else {
			System.out.println(defender.getName() + "は、力尽きた。。。");
		}
		System.out.println(Constant.BOTTOM_LINE);
		
		// enterが押下されるまで処理をストップ
		battleSleep();
		
		// 防御者の残HPをリターン
		return defenderHp ;
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
			System.out.println(Constant.TOP_LINE);
	}
	
	/**
	 * バトル開始の案内文をコンソールに出力
	 * @param c1 バトルするキャラクター
	 * @param c2 バトルするキャラクター
	 * @throws IOException
	 */
	private static void battleStartInfomation(Character c1,Character c2) throws IOException {
		System.out.println(Constant.BOTTOM_LINE);
		System.out.print(Constant.BATTLE_INFOMATOR + " > ");
		System.out.println(c1.getName() + "と、"+c2.getName() + "が、バトルを開始したワン！");
		System.out.println("　　　　　　 > Enterでバトルは進行するワン！");
		System.out.println(Constant.TOP_LINE);
		System.out.println(c1.getName() + "\t\t攻：" + c1.getBaseAtackPoint() + "\t\tHP:" + c1.getBaseHp() );
		System.out.println(c2.getName() + "\t\t攻：" + c2.getBaseAtackPoint() + "\t\tHP:" + c2.getBaseHp() );
		System.out.println(Constant.BOTTOM_LINE);
		// Enterが押下されるまで処理をストップ
		battleSleep();
	}
}
