package lesson09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice0903 {
    public static void main(String[] args) throws IOException {
        System.out.println("整数を入力してください。");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String str = reader.readLine();
        int num = Integer.parseInt(str);

        int i;
        for (i = 2; i < num; i++) {
            if (num % i == 0) {
            	System.out.println("余りが0なので、素数ではありません");
                break;
            }
        }

        if (i == num) {
            System.out.println("入力された整数は素数です。");
        }
    }
}
