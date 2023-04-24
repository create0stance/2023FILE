package java_sample.lesson06;

public class Sample0604 {
	public static void main(String[] args) {
		// 演算子の優先順位とは、結合の強さ。
		// ()がない場合、どこから式が評価されるかの優先順位。
		System.out.println(1+(2*3)+2);
		
		// 同じ優先度の場合、結合の種類により評価される順番が変わる。
		// 左結合 => 左から結合する。
		System.out.println(1 + 2 + 3 - 4 - 10);
		// 右結合 => 右から結合する。
		int n ;
		int n2;
		System.out.println(n = n2 = 2);
		
		
		// ★インクリメント、デクリメントは優先順位が高い
		int num = 1;
		// ()で括らなくても必ずこうなる
		System.out.println((int) 100000000000000000l);
		System.out.println(num = (num++));
		int a = 1;
		int b = 2;
		// 比較演算子は論理演算子より
		System.out.println((a == b) && (a == 0));
		// 
		// 【特徴】
		// 例）
		// 【結合の種類】
		
		
		// 優先順位 = 結合度の高さ
		
		
		
		
	}
}
