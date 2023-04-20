package lesson19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice1901 {
    public static void main(String[] args) throws IOException {
        System.out.println("英字を入力して下さい。");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String str1 = reader.readLine();

        // 大文字に変換
        String str2 = str1.toUpperCase();
        System.out.println(str1 + "を大文字に変換すると" + str2 + "です。");
    }
}
