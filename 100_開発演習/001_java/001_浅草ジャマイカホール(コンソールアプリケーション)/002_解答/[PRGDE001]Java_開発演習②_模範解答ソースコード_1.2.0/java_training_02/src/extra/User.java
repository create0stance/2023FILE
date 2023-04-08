package extra;

/**
 * ユーザー情報クラス
 *
 * @version 1.0
 * @author System Shared
 */
public class User {

    /** 名前 */
    private String name;

    /** 電話番号 */
    private String tel;

    /** Eメールアドレス*/
    private String email;

    /** 性別 */
    private int gender;

    /** 年齢 */
    private int age;

    /**
     * 名前取得
     *
     * @return 名前
     */
    public String getName() {
        return name;
    }

    /**
     * 名前登録
     *
     * @param name 名前
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 電話番号取得
     *
     * @return 電話番号
     */
    public String getTel() {
        return tel;
    }

    /**
     * 電話番号登録
     *
     * @param tel 電話番号
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * Eメールアドレス取得
     *
     * @return Eメールアドレス
     */
    public String getEmail() {
        return email;
    }

    /**
     * Eメールアドレス登録
     *
     * @param email Eメールアドレス
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 性別取得
     *
     * @return 性別
     */
    public int getGender() {
        return gender;
    }

    /**
     * 性別登録
     *
     * @param gender 性別
     */
    public void setGender(int gender) {
        this.gender = gender;
    }

    /**
     * 年齢取得
     *
     * @return 年齢
     */
    public int getAge() {
        return age;
    }

    /**
     * 年齢登録
     *
     * @param age 年齢
     */
    public void setAge(int age) {
        this.age = age;
    }

}
