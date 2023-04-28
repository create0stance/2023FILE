package question07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question07_07 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String str = reader.readLine();

		int price = Integer.parseInt(str);
		int discount_price = (int) (price * 0.7);

		System.out.println("3割引きで" + discount_price + "円です");
	}
}
