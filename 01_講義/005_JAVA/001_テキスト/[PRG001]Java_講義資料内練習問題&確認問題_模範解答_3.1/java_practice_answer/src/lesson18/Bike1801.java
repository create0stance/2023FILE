package lesson18;

/**
 * バイククラス
 */
public class Bike1801 {
	/** バイクの台数 */
    private static int sum = 0;

    /** ナンバー */
    private String num;

    /**
     * コンストラクタ
     *
     * @param num ナンバー
     */
    public Bike1801(String num) {
        this.num = num;
        sum++;
    }

    /**
     * バイクの台数を出力
     */
    public static void showSum() {
        System.out.println("バイクの台数は合計" + sum + "台です。");
    }
}
