package java_sample.lesson09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sample0901 {
	public static void main(String[] args) throws IOException {
		for (
				// 初期化式 iに0を代入
				int i = 0;
				// 条件式(iが5未満なら繰り返す)
				i < 5;
				// 変化式：iを1ずつ加算
				i++
				) {
			System.out.println(i + "回目の挨拶です。");
			System.out.println("こんにちは");
			
		}
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		for (String inputNumber;!(inputNumber = reader.readLine()).equals("0");) {
			System.out.println(inputNumber);			
		}
		System.out.println("終了します。");
	}
}
