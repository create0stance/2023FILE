package excellence;

/**
 * 定数クラス
 *
 * @version 2.0
 * @author System Shared
 */
public class Constant {

    // ****座席情報管理クラス用メッセージ****
    /** 座席の最大数 */
    public static final int SEAT_NUM_MAX = 30;

    // ****メインクラス用メッセージ****
    /** システムスタート時のメッセージ */
    public static final String START_MSG = "ようこそ浅草ジャマイカホールへ！\n";

    /** 予約済みだった時のエラーメッセージ */
    public static final String NOT_RESERVED_MSG = "\n※予約済みの座席です。他の座席を選択してください。\n";

    /** 予約完了メッセージ */
    public static final String RESERVED_MSG = "\n座席の予約が完了しました。";

    /** システムエラーが発生した場合のエラーメッセージ */
    public static final String SYSTEM_ERROR_MSG = "システムエラーが発生しました。";

    /** システム終了時のメッセージ */
    public static final String SYSTEM_END_MSG= "システムを終了します。";

    // ****入力制御クラス用メッセージ****
    /** 座席入力メッセージ */
    public static final String INPUT_SEAT_NUM_MSG = "何番の座席を予約しますか？（1～30）";

    /** 名前入力メッセージ */
    public static final String INPUT_USER_NAME_MSG= "\nあなたのお名前を入れてください。";

}
