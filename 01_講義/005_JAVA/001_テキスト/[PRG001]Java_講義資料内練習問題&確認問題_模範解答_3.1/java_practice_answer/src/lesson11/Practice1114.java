package lesson11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Practice1114 {
    public static void main(String[] args) throws IOException {
        int[] numbers = new int[3];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 3; i++) {
            String str = reader.readLine();
            int num = Integer.parseInt(str);
            numbers[i] = num;
        }

        // sort()メソッドを使って値を昇順にソートする
        Arrays.sort(numbers);

        for (int value : numbers) {
            System.out.println(value);
        }
    }
}
