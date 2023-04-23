/**
 * 読まれなかった数字
 *
 * 1～100の数字がランダムに、一度ずつ読まれる
 * ただし、1～100の数字のうち、ランダムに1つだけ読まれない(読み上げる数字は重複しない）
 * この1つの数字を特定するプログラムを作成せよ
 *
 * 例）1～100の数字がランダムに一度ずつ読まれるが、3のみ読まれない
 *
 * 数字を読み上げます：
 * 12 54 59 86 67 28 37 33 18 99 24 47 48 98 58 0 25 87 39 31 57 34 84 93 16 100 61 42 21 66 38 36 20 81 72 56 76 5 73 62 41 79 2 26 13 63 32 40 15 89 70 29 23 88 78 45 35 43 46 92 60 97 74 8 69 53 49 6 85 17 4 50 75 90 30 9 14 80 83 10 95 19 52 64 82 1 44 55 91 22 7 71 65 11 96 94 77 51 27 68

 * //ここに3を特定する何らかの処理を追加
 *
 * 読まれなかった数字は＞3
 *
 * 正解は3！さすがだ！
 *
 */

package section04_summary.challenge04;

import java.util.Random;
import java.util.Scanner;

public class UnreadableNumbers {

	public static void main(String[] args) {

		// 1～100のうち、ランダムで1つの数字を準備（読まれなかった数字）
		Random rand = new Random();
		int unreadableNum = rand.nextInt(100) + 1;

		/*
		 * ここにコードを追記
		 *
		 */

		// 回答を入力する
		System.out.print("読まれなかった数字は＞");
		Scanner stdIn = new Scanner(System.in);
		int inputInt = stdIn.nextInt();

		// 回答の正否を判定
		if (inputInt == unreadableNum) {
			System.out.println("\n正解は" + unreadableNum + "！さすがだ！");
		} else {
			System.out.println("\n正解は" + unreadableNum + "！残念！");
		}

		stdIn.close();

	}

}
