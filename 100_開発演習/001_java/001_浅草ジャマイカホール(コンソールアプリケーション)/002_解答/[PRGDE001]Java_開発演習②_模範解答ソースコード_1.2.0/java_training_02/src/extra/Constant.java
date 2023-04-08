package extra;

/**
 * 定数クラス
 *
 * @version 3.0
 * @author System Shared
 */
public class Constant {

    // ****座席情報管理クラス用メッセージ****
    /** 座席の最大数 */
    public static final int SEAT_NUM_MAX = 30;

    // ****メインクラス用メッセージ****
    /** システムスタート時のメッセージ */
    public static final String START_MSG = "ようこそ浅草ジャマイカホールへ！\n";

    /** 満席だった時のメッセージ */
    public static final String NO_VACANT_MSG = "\n満席です。";

    /** 予約完了メッセージ */
    public static final String RESERVED_MSG = "\n座席の予約が完了しました。";

    /** システムエラーが発生した場合のエラーメッセージ */
    public static final String SYSTEM_ERROR_MSG = "システムエラーが発生しました。";

    /** システム終了時のメッセージ */
    public static final String SYSTEM_END_MSG= "システムを終了します。";

    // ****入力制御クラス用メッセージ****
    /** 名前入力メッセージ */
    public static final String INPUT_USER_NAME_MSG= "\nあなたのお名前を入れてください。";

    /** 電話番号入力メッセージ */
    public static final String INPUT_USER_TEL_MSG= "\nあなたの電話番号を入れてください。";

    /** メールアドレス入力メッセージ */
    public static final String INPUT_USER_EMAIL_MSG= "\nあなたのメールアドレスを入れてください。";

    /** 性別入力メッセージ */
    public static final String INPUT_USER_GENDER_MSG= "\nあなたの性別を入れてください。";

    /** 男性だった場合の選択肢 */
    public static final String INPUT_USER_MALE_MSG= "\n男性 ・・・ 1";

    /** 女性だった場合の選択肢 */
    public static final String INPUT_USER_FEMALE_MSG= "\n女性 ・・・ 2";

    /** 年齢入力メッセージ */
    public static final String INPUT_USER_AGE_MSG= "\nあなたの年齢を入れてください。";

    // ****自動選択ロジッククラス用メッセージ****
    /** 空席が見つからなかった場合に使用する値 */
    public static final int NO_VACANT_NUM = -1;
}
