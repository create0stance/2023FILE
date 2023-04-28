package lesson09;

import java.util.Arrays;

public class Sample0912 {
    public static void main(String[] args) {
        int[] numbers = { 3, 4, 2, 1, 5 };

        // 配列をソートする
        Arrays.sort(numbers);

        for (int value : numbers) {
            System.out.println(value);
        }
    }
}
