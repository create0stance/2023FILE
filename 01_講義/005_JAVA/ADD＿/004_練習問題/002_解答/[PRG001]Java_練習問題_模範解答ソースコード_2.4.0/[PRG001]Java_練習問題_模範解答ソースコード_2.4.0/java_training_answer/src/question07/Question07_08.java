package question07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question07_08 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str1 = br.readLine();
		String str2 = br.readLine();
		String str3 = br.readLine();

		int price1 = Integer.parseInt(str1);
		int discount_price1 = (int) (price1 * 0.7);

		int price2 = Integer.parseInt(str2);
		int discount_price2 = (int) (price2 * 0.7);

		int price3 = Integer.parseInt(str3);
		int discount_price3 = (int) (price3 * 0.7);

		int sum = discount_price1 + discount_price2 + discount_price3;
		System.out.println("合計" + sum + "円");

		int average = (int) sum / 3;
		System.out.println("平均" + average + "円");
	}
}
