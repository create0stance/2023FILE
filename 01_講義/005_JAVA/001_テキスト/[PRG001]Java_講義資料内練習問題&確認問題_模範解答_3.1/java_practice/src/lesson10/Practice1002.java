package lesson10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice1002 {
    public static void main(String[] args) throws IOException {
        System.out.println("3人のテストの点数を入力してください。");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] test = new int[3];

        for (int i = 0; i < test.length; i++) {
            String str = reader.readLine();
            int score = Integer.parseInt(str);
            test[i] = score;
        }

        int max = 100;
        for (int i = 0; i < test.length; i++) {
            if (test[i] >= max) {
                max = test[i];
            }
        }

        int min = 0;
        for (int i = 0; i < test.length; i++) {
            if (test[i] <= min) {
                min = test[i];
            }
        }

        for (int i = 0; i < test.length; i++) {
            System.out.println(i + "番目の人の点数は" + test[i] + "です。");
        }
        System.out.println("最高点は" + max + "点です。");
        System.out.println("最低点は" + min + "点です。");
    }
}
