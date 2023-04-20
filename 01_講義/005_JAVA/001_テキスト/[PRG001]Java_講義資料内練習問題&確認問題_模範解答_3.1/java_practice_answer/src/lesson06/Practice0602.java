package lesson06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice0602 {
    public static void main(String[] args) throws IOException {
        System.out.println("足し算をします。");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("1つ目の整数を入力してください。");
        String str1 = reader.readLine();

        System.out.println("2つ目の整数を入力してください。");
        String str2 = reader.readLine();

        // strに代入されている値をnumに記憶させる
        int num1 = Integer.parseInt(str1);
        int num2 = Integer.parseInt(str2);

        System.out.println("足し算の結果は" + (num1 + num2) + "です。");
    }
}
