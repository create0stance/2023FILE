package lesson22;

/**
 * モバイルコンピュータークラス
 */
public class MobileComputer2202 implements Computer2202 {
    /** 型番 */
    private String id;

    /**
     * 型番を設定
     *
     * @param id 型番
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 型番を取得
     *
     * @return 型番
     */
    public String getId() {
        return id;
    }

    /**
     * メッセージを出力
     */
    public void showMessage() {}

    /**
     * コマンドを設定
     *
     * @param command コマンド
     */
    public void setCommand(String command) {}
}
