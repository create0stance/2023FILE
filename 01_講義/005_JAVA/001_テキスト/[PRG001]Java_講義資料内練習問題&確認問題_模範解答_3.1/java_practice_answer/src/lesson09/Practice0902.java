package lesson09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice0902 {
    public static void main(String[] args) throws IOException {
        System.out.println("整数を入力してください。");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String str = reader.readLine();
        int num = Integer.parseInt(str);

        // for文①
        for (int i = 1; i <= num; i++) {
            // for文②
            for (int j = 1; j <= num - i; j++) {
                System.out.print(" ");
            }
            System.out.print("*\n");
        }
    }
}
