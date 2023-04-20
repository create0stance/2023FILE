package lesson25;
/**
 * エラーメッセージ表示クラス
 */
public class InputPasswordException2502 extends Exception {
	/**
	 * エラーメッセージを表示
	 */
    public InputPasswordException2502() {
        super("パスワードは4文字以上8文字以下で入力してください。");
    }
}
