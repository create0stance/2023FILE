package lesson11;

public class Practice1112 {
    public static void main(String[] args) {
        for (int i = 5; i < 21; i++) {
            // 変数iの値が8になったときスキップする
            if (i == 8) {
                continue;
            }

            System.out.println(i);
            // 変数iの値が10になったとき強制終了する
            if (i == 10) {
                break;
            }
        }

    }
}
