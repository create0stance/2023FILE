/**
 * 配列の代入と出力
 *
 * 実行例を参考に、プログラムを完成させてください。
 * 標準入力した5個の数字を配列に代入し、それらを全て足し算して、結果を出力してください。
 *
 * （実行例）
 * 1個目＞10
 * 2個目＞20
 * 3個目＞30
 * 4個目＞40
 * 5個目＞50
 * 1個目の数字は：10
 * 2個目の数字は：20
 * 3個目の数字は：30
 * 4個目の数字は：40
 * 5個目の数字は：50
 * 合計は：150
 *
 * ====
 * ScannerクラスはBufferedReaderクラスの仲間で、標準入力するための機能を持ちます。
 * 文字列を入力する場合は「String target = stdIn.next();」のように使います。
 * 整数を入力する場合は「int target = stdIn.nextInt();」のように使います。
 * BRと違って、文字と数値の変換が不要です。
 * また、Scanner型の変数は最後に.close();することが推奨されています(練習問題ではcloseしなくても問題ありません)。
 */

package section01_array.challenge02;

import java.util.Scanner;

public class Sum {

	public static void main(String[] args) {
		// 標準入力の準備
		Scanner stdIn = new Scanner(System.in);


		// 標準入力の終了
		stdIn.close();
	}

}
