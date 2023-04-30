package review;

public class Day6Answer {
public static void main(String[] args) {
		
		//	①Calcクラスを作成せよ
		//		【呼び出し側】
		//		変数calcを宣言し、Calcオブジェクトを生成し代入せよ
		Calc calc = new Calc();
		//	②Calcクラスに以下のメソッドを作成せよ
		//		・メソッド名 concatText
		//		・処理 引数で受け取った「文字列1」と「文字列2」を連結しコンソールに出力する
		//		・引数 
		//			String str1 文字列1
		//			String str2 文字列2
		//		・戻り値 なし
		//			
		//	【呼び出し側】
		//		Day6クラスのメインメソッド内で、以下の変数を使用し、concatTextメソッドを実行せよ。
		//		実行結果：以下がコンソールに出力される
		//		朝ですね。おはようございます！
		String str1 = "朝ですね。";
		String str2 = "おはようございます！";
		calc.concatText(str1, str2);

		//	③Calcクラスに以下のフィールドを作成せよ
		//		・String name 
		//		・double versionNumber
		//	
		//	【呼び出し側】
		//		・Calcクラスのフィールドに値をセットせよ。
		//		・nameフィールドへ「計算君」を代入
		calc.name = "計算君";
		//		・versionNumberフィールドへ「1.0」を代入
		calc.versionNumber = 1.0;
		//		・Calcクラスのフィールドの値を取得し、以下をコンソール出力せよ。
		//		計算君のバージョンは1.0です。
		System.out.println(calc.name + "のバージョンは" + calc.versionNumber + "です。");

		//	④Calcクラスに以下のメソッドを作成せよ
		//		・メソッド名：updateAndGetVerison
		//		・処理：versionフィールドの値を0.1アップし、versionフィールドの値をリターンする
		//		・引数 なし
		//		・戻り値：double バージョン情報
		//	【呼出側】
		//		Day6クラスのメインメソッド内で、updateAndGetVerisonメソッドを実行せよ。
		//		updateAndGetVerisonの戻り値を利用し、以下をコンソールに出力せよ。
		//		計算君をバージョン1.1にアップデートしました。
		System.out.println(calc.name + "をバージョン" + calc.updateAndGetVerison() + "にアップデートしました。");

		//	⑤Calcクラスに以下のメソッドを作成せよ
		//		・メソッド名：trapezoid
		//		・処理：台形の面積を計算し、コンソール出力する
		//		※(上底+下底）×高さ÷２
		//		・引数
		//			上底：int topLine 
		//			下底：int underLine
		//			高さ：int height 
		//		・戻り値：なし
		//		・出力結果
		//		上底10cm下底20cm高さ7cmの台形の面積は105cm2です。
		//	【呼出側】
		//		Day6クラスのメインメソッド内で、以下の変数を使用し、trapezoidメソッドを実行せよ。
		int topLine = 10;
		int underLine = 20;
		int height = 7;
		calc.trapezoid(topLine, underLine, height);

		//	⑥Calcクラスに以下のメソッドを追加せよ。
		//		メソッド名：inTax
		//		処理：税込み価格を計算し、呼び出し元にリターンする。
		//		引数：int itemPrice
		//		戻り値:int 税込み価格
		//		※消費税率は10%とする。
		//		消費税率はinTaxメソッド内に初期値0.1の変数を宣言し使用せよ。
		//	
		//		【呼び出し側】：
		//		Day6クラスのメインメソッド内で、以下の変数を使用し、inTaxメソッドを実行せよ。
		//		int price = 1000;
		//		int taxPrice;
		//		※taxPriceにinTaxメソッドの処理結果を代入し、consoleに、以下を出力せよ。
		//		1000円の税込価格は1100円です。
		int price = 1000;
		int taxPrice = calc.inTax(price);
		String infoStr = price + "円の税込価格は" + taxPrice + "円です。";
		System.out.println(infoStr);

		//	⑦Calcクラスにメソッドを追加せよ。
		//		メソッド名：getCountryNameWithNum
		//		処理：受け取った国番号から、対応した国名を呼び出し元にリターンする。
		//		引数：int countryNum 国番号
		//		戻り値：String 国名 or	不明
		//		処理：
		//			以下の関係性を元に「国番号」に応じた「国名」をリターンする。
		//			※存在しない国番号の場合「不明」をリターンする
		//			※国名情報はgetCountryNameWithNumメソッド内に配列を作成し、管理する。
		//			国番号:	国名
		//			0：		日本;
		//			1：		アメリカ;
		//			2：		中国
		//			3：		韓国
		//			4：		オーストリア
		//	
		//	呼び出し側：
		int[] contryCodes = { 0, 1, 2, 3, 4, 5 };
		//	上記配列をループ処理し、
		//		ループ内でgetCountryNameWithNumメソッドを実行。
		//		以下をコンソール出力せよ。
		//		国番号0の国名は「日本」です。
		//		国番号1の国名は「アメリカ」です。
		//		国番号2の国名は「中国」です。
		//		国番号3の国名は「韓国」です。
		//		国番号4の国名は「オーストラリア」です。
		//		国番号5の国名は「不明」です。

		// 国番号をループ処理
		for (int i = 0; i < contryCodes.length; i++) {
			// 国番号を変数に代入
			int countryNum = contryCodes[i];
			// 国名を取得し変数に代入
			String countryName = calc.getCountryNameWithNum(countryNum);
			//出力文を作成
			String info = "国番号" + countryNum + "の国名は「" + countryName + "」です。";
			// 出力
			System.out.println(info);

		}
		//	⑧Calcクラスにメソッドを追加せよ。
		//		・メソッド名：totalValueNum1ToNum2
		//		処理：指定の整数～指定の整数までの合計値を計算し、呼び出し元にリターンする
		//		※指定値も含め処理する。	
		//		・引数
		//			int num1
		//			int num2 
		//		・戻り値：long num1からnum2に含まれる整数の合計値
		//	
		//	呼び出し側：
		//		totalValueNum1ToNum2メソッドを利用し、
		//		1～10000までの合計値を求め、
		//		以下をコンソール出力せよ。
		//		1～10000に含まれる整数の合計値は50005000です。
		int min = 1;
		int max = 10000;
		long totalValue = calc.totalValueNum1ToNum2(min, max);
		String totalValueText = min + "~" + max + "に含まれる整数の合計値は" + totalValue + "です。";
		System.out.println(totalValueText);
	}
}
