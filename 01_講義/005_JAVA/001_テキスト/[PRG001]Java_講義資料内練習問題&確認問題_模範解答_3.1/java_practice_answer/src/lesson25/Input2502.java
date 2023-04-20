package lesson25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * パスワード入力クラス
 */
public class Input2502 {

	/**
	 * パスワードを入力
	 * @throws IOException
	 * @throws InputPasswordException2502
	 */
    public void inputPassword() throws IOException, InputPasswordException2502 {
        System.out.println("パスワードを入力してください。（4文字以上8文字以内）");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String password = reader.readLine();

        // 入力されたパスワードの文字数をチェック
        checkPassword(password);

        System.out.println("パスワードは" + password + "です。");
    }

    /**
     * パスワードをチェック
     * @param password
     * @throws InputPasswordException2502
     */
    private void checkPassword(String password) throws InputPasswordException2502 {
        if (password.length() < 4 || 8 < password.length()) {
            throw new InputPasswordException2502();
        }
    }
}
