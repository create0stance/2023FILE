package java_sample.lesson07;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Sample0701 {
	public static void main(String[] args) {

		// ★配列変数の宣言
		// 要素の型[] 配列変数名 = new 要素の型[要素数];
		double[] heights = new double[4];
		
		System.out.println(heights);
		
		//[I@ハッシュコード]
		// ハッシュコード：オブジェクトに割り当てられた16進数の値（メモリ上のアドレスを整数値に変換）
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(br);
		
		heights[5] = 167;

	}

}
