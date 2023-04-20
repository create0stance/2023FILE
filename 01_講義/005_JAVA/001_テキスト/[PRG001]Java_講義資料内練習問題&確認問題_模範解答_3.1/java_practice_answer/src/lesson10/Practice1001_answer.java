package lesson10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice1001_answer  {
    public static void main(String[] args) throws IOException {
        System.out.print("整数値を入力してください>");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String str = reader.readLine();
        int num = Integer.parseInt(str);

        // 入力された数値に応じて異なる文字列を出力
        if (num <= 5) {
            System.out.println("5以下の値です。");
        } else if (6 <= num && num <= 9) {
            System.out.println("6～9までの値です。");
        } else if (10 <= num) {
            System.out.println("10以上の値です。");
        }

        System.out.println("以上で処理は終了です。");
    }
}
