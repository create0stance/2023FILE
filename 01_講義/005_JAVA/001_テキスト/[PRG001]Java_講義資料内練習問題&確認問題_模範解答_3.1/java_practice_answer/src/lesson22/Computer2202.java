package lesson22;

/**
 * コンピューターインターフェイス
 */
public interface Computer2202 {
    String START_MESSAGE = "Welcome";

    /**
     * メッセージを出力
     */
    void showMessage();

    /**
     * コマンドを設定
     * @param command コマンド
     */
    void setCommand(String command);
}
