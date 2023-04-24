package java_sample.lesson07;

public class Sample0703 {
	public static void main(String[] args) {
		// 配列を初期化
		int[] height1 = {162, 177, 154, 185};
		int[] height2;
		
		// 配列変数height1の値を配列変数height2に代入
		height2 = height1;
		
		// height1[0]の値を上書き
		height1[0] = 180;
		
		// height2[0]を出力
		System.out.println("1人目の身長は" + height2[0] + "cmです。");
		
		System.out.println(height1);
		System.out.println(height2);
	}
}
