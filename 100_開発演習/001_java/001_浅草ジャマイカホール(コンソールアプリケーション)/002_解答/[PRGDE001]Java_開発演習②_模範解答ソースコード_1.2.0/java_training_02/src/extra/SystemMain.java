package extra;

/**
 * システムメインクラス
 *
 * @version 3.0
 * @author System Shared
 */
public class SystemMain {

    /**
     * メイン
     */
    public static void main(String[] args) {

        // システム開始メッセージの表示
        System.out.println(Constant.START_MSG);

        try {
            // 座席情報を初期化する
            SeatsManager.init();
            
            // ユーザー情報入力機能を利用してユーザー情報を得る
            User user = InputController.inputUserInfo();
            
            // 座席自動予約機能を実行する
            boolean isReserved = SeatsManager.reserveSeat(user);

            // 予約が完了した場合
            if (isReserved) {

                // 予約完了メッセージを出力する
                System.out.println(Constant.RESERVED_MSG);
            }

            // 例外が発生した場合
        } catch (Exception e) {
            // エラーメッセージを出力する
            System.out.println(Constant.SYSTEM_ERROR_MSG);
            System.out.println(Constant.SYSTEM_END_MSG);
        }
    }
}
