package review;
/**
 *  Java1日目復習クラス：解答例
 *  ・標準出力
 *  ・リテラル
 *  ・変数
 */
public class Day1Answer {
	public static void main(String[] args) {
		
		/*
		 * Day1復習問題です。
		 * [目的]
		 * ・標準出力の使い方の復習。
		 * ・リテラルの種類とそれぞれの使い方の復習と応用。
		 * ・変数の宣言方法と基本型の値の代入。
		 * 
		 * [ストーリー]
		 * 149800円のiPhone14Proを1000台購入しようと思っています。
		 * 予算は、25億円です。
		 * この場合の予算残高を計算してみましょう。
		 * 
		 * [問題の解き方]
		 * 問題の記載された箇所の下に、コードを書いていきましょう。
		 * 例）↓ */
		 // 1)コンソールにDAY1復習問題と出力しよう。	
		 System.out.println("DAY1復習問題");
		
		// 1)コンソール上に以下の文言を出力しよう
		// 標準出力、リテラル、変数の復習と応用
		// ================================
		System.out.println("標準出力、リテラル、変数の復習と応用");
		System.out.println("================================");

		// 2)商品名を意味する文字列型の変数「itemName」を宣言しよう。
		String itemName;

		// 3)itemNameにiPhone 14 Proを代入しよう。
		itemName = "iPhone 14 Pro";

		// 4)単価を意味する整数型の変数「unitPrice」を宣言しよう
		int unitPrice;

		// 5)unitPriceに149800を代入しよう
		unitPrice = 149800;

		// 6)購入数を意味する整数型の変数「purchaseNumber」を宣言し、
		// 初期値「1000」を代入しよう
		int purchaseNumber = 1000;

		// 7)ここまでに使用した変数を用いコンソールに以下の内容を出力しよう。
		// iPhone 14 Proを1000台、購入します。
		// 単価は149800円です。
		System.out.println("iPhone 14 Proを" + purchaseNumber + "台、購入します。");
		System.out.println("単価は" + unitPrice + "円です。");

		// 8)合計価格を意味する整数型の変数「totalPrice」を宣言し、
		// 初期値として単価*購入数を代入しよう
		int totalPrice = unitPrice * purchaseNumber;

		// 9)ここまでに使用した変数を用いコンソールに以下の内容を出力しよう。
		// iPhone 14 Proを1000個、購入した場合の合計価格は以下となります。
		// 合計価格：\149800000
		// ================================
		System.out.print(itemName + "を" + purchaseNumber + "個、");
		System.out.println("購入した場合の合計価格は以下となります。");
		System.out.println("合計価格：\\" + totalPrice);
		System.out.println("================================");

		// 10)予算を意味する整数型の変数budgetを宣言し、初期値2500000000を代入しよう。
		long budget = 2500000000l;

		// 【プチ応用問題】
		// 1）ここまでに使用した変数を用いコンソールに以下の内容を出力しよう。
		// 予算は、25億円です。
		// iphone14Proを単価149800円で1000台購入した場合、
		// 予算残高は、2350200000円となります。
		System.out.println("予算は、" + budget / 100000000 + "億円です。");
		// ↓こんな書き方もOK(※除算より乗算の方が計算処理は早い。)
// 		System.out.println("予算は、" + (int)(budget * 0.00000001) + "億円です。");
		System.out.println(itemName + "を単価" + unitPrice + "円で" + purchaseNumber + "台購入した場合、");
		System.out.println("予算残高は、" + (budget - totalPrice) + "円となります。");
		// 補足：想定通りに計算し結果を出力するには、「演算子」の優先順位の知識が必要。(今日の講義で学習します。)

		// 【応用問題】
		// 1)割引率を意味する浮動小数点数型の変数discountRateを代入し、初期値0.1を代入しよう
		double discountRate = 0.1;
		
		// 2)割引後単価を意味する整数型の変数unitPriceAfterDiscountを宣言しよう。
		int unitPriceAfterDiscount ;
		
		// 3)unitPriceとdiscountRateを利用し、unitPriceAfterDiscountに割引後の単価を代入せよ。
		// 補足：整数と浮動小数点を計算する時は、型変換(キャスト)が必要。
		// 今日の講義内容「型変換」で学習するよ。
		unitPriceAfterDiscount = (int)(unitPrice * (1 - discountRate));
		// こんな書き方もOK
		unitPriceAfterDiscount = unitPrice - (int)(unitPrice * discountRate);
		
		// 4)ここまでに使用した変数を用いコンソールに以下の内容を出力しよう。
		// 割引後の単価は134820円です。
		System.out.println("割引後の単価は" + unitPriceAfterDiscount + "円です。");

	}
}
