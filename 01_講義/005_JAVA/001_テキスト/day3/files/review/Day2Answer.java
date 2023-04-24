package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day2Answer {
	public static void main(String[] args) throws IOException {
		/*
		 * Day2復習問題です。
		 * [目的]
		 * ・標準入力で学んだ知識を使う。
		 * ・式と演算子で学んだ知識を使う。
		 * 
		 * [ストーリー]
		 * iPhone14Pro専門店の接客アプリです。
		 * 1,ユーザーの名前を聞きます。
		 * 2,iPhone14Proの購入希望数を聞きます。
		 * 3,合計価格を伝えます。
		 * 4,キャンペーン価格を伝えます。
		 * 5,店長に販売報告を行います。
		 * 学んだ知識をベースに、挑戦しましょう。
		 * 
		 * [目安時間]
		 * 30～40分程度
		 * 頑張って問題11までは解こう！
		 * 問題15まで解ければOK！
		 * 問題16まで解ければバッチリ！
		 * 
		 * [問題の解き方]
		 * 1.コンソールへの出力が求められる問題について、
		 * 			・変数が利用できる個所は変数を使用しましょう。
		 * 			・ []の記載がある箇所については、入力値により出力結果が異なります。
		 * 			・ []の出力は不要です。
		 * 2.問題の記載された箇所の下に、コードを書いていきましょう。
		 * 例）↓ */
		// 1)DAY2復習問題：iPhone14Pro専門店へ、ようこそ！	
		System.out.println("DAY2復習問題：iPhone14Pro専門店へ、ようこそ！");

		// 1)商品名を意味する文字列型の変数itemNameを宣言し、初期値iPhone14Proを代入しよう。
		String itemName = "iPhone14Pro";

		// 2)商品価格を意味する整数型の変数itemPriceを宣言し、初期値149800を代入しよう。
		int itemPrice = 149800;

		// 3)商品在庫数を意味する整数型の変数itemStockを宣言し、初期値500を代入しよう。
		int itemStock = 500;

		// 4)標準入力文字取得の準備：
		// BufferedReader型の変数readerに、標準入力文字を取得するBufferedReaderオブジェクトを生成し代入しよう。
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		// 5)コンソール上に以下の文言を出力しよう
		// いらっしゃいませ、お名前を入力してください。
		System.out.println("いらっしゃいませ、お名前を入力してください。");

		// 6) 「ユーザー名」を意味する文字列型の変数「userName」を宣言し、「入力された文字列」を代入しよう。
		// HINT:BufferedReaderのreadLineメソッドを利用しよう。
		String userName = reader.readLine();

		// 7)入力された文字列を利用し、コンソール上に以下の文言を出力しよう
		// [シマエナガ]さんですね。
		System.out.println(userName + "さんですね。");

		// 8)コンソール上に以下の文言を出力しよう
		// iPhone14Proの在庫は500台です。
		// iPhone14Proを、何台購入しますか？
		System.out.println(itemName + "の在庫は" + itemStock + "台です。");
		System.out.println(itemName + "を、何台購入しますか？");

		// 9)「入力された購入数」を意味する文字列型の変数「inputPurchaseNumber」を宣言し、「入力された文字列」を代入しよう。
		// HINT:BufferedReaderのreadLineメソッドを利用しよう。
		String inputPurchaseNumber = reader.readLine();

		// 10)「購入数」を意味する整数型の変数purchaseNumberを宣言し、
		// 初期値として「inputPurchaseNumberを整数に変換」し代入しよう。
		int purchaseNumber = Integer.parseInt(inputPurchaseNumber);

		// 11)コンソール上に以下の文言を出力しよう
		// iPhone14Proを、[300]台ですね。
		// 合計金額は[44940000]円となります。
		// ==================================================
		System.out.println(itemName + "を、" + inputPurchaseNumber + "台ですね。");
		System.out.println("合計金額は" + purchaseNumber * itemPrice + "円となります。");

		// 12）割引率を意味するfloat型の変数discountRateを宣言し、0.3を代入しよう。
		float discountRate = 0.3f;

		// 13 )コンソール上に以下を出力しよう
		// ですが、今なら何と新春キャンペーン中で3割引きです！！
		System.out.println("ですが、今なら何と新春キャンペーン中で" + (int) (discountRate * 10) + "割引きです！！");

		// 14)割引合計価格を意味する整数型の変数discountTotalPriceを宣言し
		// 割引された合計金額を代入しよう。
		int discountTotalPrice = (int) (itemPrice * (1 - discountRate) * purchaseNumber);

		// 15)コンソール上に以下を出力しよう
		// 割引後の合計金額は[31458000]円となります。
		// ご購入ありがとうございました。
		// ==================================================
		System.out.println("割引後の合計金額は" + discountTotalPrice + "円となります。");
		System.out.println("ご購入ありがとうございました。");
		System.out.println("==================================================");

		// 16)在庫：itemStockから購入数：purchaseNumberの値を減算しよう
		itemStock -= purchaseNumber;

		// 17)コンソール上に以下の文言を出力しよう
		// 店長！iPhone14Proが、[300]台、売れました！
		// 残りの在庫は[200]台です。
		// キャンペーン価格で販売しました。
		// 通常価格で販売した場合との差額は[-13482000]円です。
		System.out.println("店長！iPhone14Proが、" + purchaseNumber + "台、売れました！");
		System.out.println("残りの在庫は" + itemStock + "台です。");
		System.out.println("キャンペーン価格で販売しました。");
		System.out.println("通常価格で販売した場合との差額は" + (discountTotalPrice - itemPrice * purchaseNumber) + "円です。");

		/*
		 * 出力例：
		DAY2復習問題：iPhone14Pro専門店へ、ようこそ！
		いらっしゃいませ、お名前を入力してください。
		シマエナガ
		シマエナガさんですね。
		iPhone14Proの在庫は500台です。
		iPhone14Proを、何台購入しますか？
		100
		iPhone14Proを、300台ですね。
		合計金額は44940000円となります。
		ですが、今なら何と新春キャンペーン中で3割引きです！！
		割引後の合計金額は31458000円となります。
		ご購入ありがとうございました。
		==================================================
		店長！iPhone14Proが、300台、売れました！
		残りの在庫は200台です。
		キャンペーン価格で販売しました。
		通常価格で販売した場合との差額は-13482000円です。
		 */
	}
}