package question09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question09_08 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("1を入力してください");
		String str1 = br.readLine();
		int num = Integer.parseInt(str1);

		System.out.println((num == 1) ? "1が入力されました" : "1以外が入力されました");
	}
}
