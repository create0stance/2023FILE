package lesson29;

/**
 * 電話クラス
 */
public class Phone2903 {
    /** 電話番号 */
    protected String number;

    /**
     * コンストラクタ
     *
     * @param number 電話番号
     */
    public Phone2903(String number) {
        this.number = number;
    }

    /**
     * 電話を掛ける
     *
     */
    public void call() {
        System.out.println("プルルルル！");
    }
}
