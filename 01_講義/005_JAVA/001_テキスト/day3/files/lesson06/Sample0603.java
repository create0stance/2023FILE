package java_sample.lesson06;

public class Sample0603 {
	public static void main(String[] args) {
		// 初期化
		int num1 = 1;
		int num2 = 0;
		
		//後置きインクリメントを利用しnum1を1加算
		num2 = num1++;
		
		System.out.println("num2の値は" + num2 + "です。");
		System.out.println("num1の値は" + num1 + "です。");
		
		num1 = 1;
		num2 = 0;
		
		// 前置きインクリメントを使用しnum1を1加算
		num2 = ++num1;
		System.out.println("num2の値は" + num2 + "です。");
		System.out.println("num1の値は" + num1 + "です。");
		
		//ややこしいから
		num1 = 1;
		num2 = 0;
		
		// インクリメントを使った処理は切り分けて処理する。
		num1++;
		num2 = num1;
		System.out.println("num2の値は" + num2 + "です。");
		System.out.println("num1の値は" + num1 + "です。");
		
		System.out.println("代入演算子を利用する");
		
		//代入演算子：代入と演算を同時に行う
		num1 = 1;
		num2 = 10;
		
		// num1に1を加算し、num1に代入。
		num1 += 1;
		num1 -= 1;
		
		
		
	
		
	}

}
