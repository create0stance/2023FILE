package lesson29;

/**
 * スマートフォンクラス
 */
public class SmartPhone2903 extends Phone2903 {
    /** Eメールアドレス */
    private String email;

    /**
     * コンストラクタ
     *
     * @param email Eメールアドレス
     */
    public SmartPhone2903(String email) {
        super("09012345678");
        this.email = email;
    }
    /**
     * 通話
     */
    public void call() {
        System.out.println("ピロピロピロ！");
    }

    /**
     * 携帯電話の情報を表示
     */
    public void showInformation() {
        System.out.println("電話番号：" + this.number);
        System.out.println("Eメールアドレス：" + this.email);
    }
}
