package extra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 入力制御クラス
 *
 * @version 3.0
 * @author System Shared
 */
public class InputController {

    /**
     * ユーザー情報入力機能
     *
     * @return ユーザー情報
     * @throws IOException 入出力例外
     */
    public static User inputUserInfo() throws IOException {
        // 入力準備
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 名前入力処理
        System.out.println(Constant.INPUT_USER_NAME_MSG);
        System.out.print("＞");
        String name = br.readLine();

        // 電話番号入力処理
        System.out.println(Constant.INPUT_USER_TEL_MSG);
        System.out.print("＞");
        String tel = br.readLine();

        // メールアドレス入力処理
        System.out.println(Constant.INPUT_USER_EMAIL_MSG);
        System.out.print("＞");
        String email = br.readLine();

        // 性別入力処理
        System.out.println(Constant.INPUT_USER_GENDER_MSG);
        System.out.println(Constant.INPUT_USER_MALE_MSG);
        System.out.println(Constant.INPUT_USER_FEMALE_MSG);
        System.out.print("＞");
        String genderStr = br.readLine();

        // 年齢入力処理
        System.out.println(Constant.INPUT_USER_AGE_MSG);
        System.out.print("＞");
        String ageStr = br.readLine();

        // 性別、年齢を数値に変換
        int gender = Integer.parseInt(genderStr);
        int age = Integer.parseInt(ageStr);

        // ユーザー情報を作成し入力された値を格納する
        User user = new User();
        user.setName(name);
        user.setTel(tel);
        user.setEmail(email);
        user.setGender(gender);
        user.setAge(age);

        return user;
    }
}
