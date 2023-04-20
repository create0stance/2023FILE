package lesson08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice0801 {
    public static void main(String[] args) throws IOException {
        System.out.println("性別を入力してください。");
        System.out.println("「M」か「F」を入力してください。");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String ans = reader.readLine();

        switch (ans) {
        case "M":
            // 変数ansの値が「M」の場合
            System.out.println("性別を男性で登録しました。");
            break;
        case "F":
            // 変数ansの値が「F」の場合
            System.out.println("性別を女性で登録しました。");
            break;
        }
    }
}
