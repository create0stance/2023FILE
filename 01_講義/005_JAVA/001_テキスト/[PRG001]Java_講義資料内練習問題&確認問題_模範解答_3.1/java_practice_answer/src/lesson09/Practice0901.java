package lesson09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice0901 {
    public static void main(String[] args) throws IOException {
        System.out.println("整数を入力してください。");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int num = 0;
        int sum = 0;

        while (num != -1){
            String str = reader.readLine();
            num = Integer.parseInt(str);
            if (num != -1) {
                sum += num;
            }
        }
        System.out.println("整数の合計値は" + sum + "です。");
    }
}
