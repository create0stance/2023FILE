package excellence;

/**
 * システムメインクラス
 *
 * @version 2.0
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
            // 座席番号確認用
            int seatNum = 0;

            // 予約可否情報格納用
            boolean canReserve = false;
            
            // 座席情報の初期化
            SeatsManager.init();

            do {
                // 座席番号入力機能を利用して座席番号を得る
                seatNum = InputController.inputSeatNum();

                // 空席確認機能を利用して入力された座席が空席か調べる
                canReserve = SeatsManager.checkVacantSeat(seatNum);

                // 指定された座席が予約済みであった場合
                if (!canReserve) {
                    // 予約済みのエラーメッセージを表示
                    System.out.println(Constant.NOT_RESERVED_MSG);
                }
                // 指定された座席が予約済みの座席である場合入力ををやり直す
            } while (!canReserve);

            // 座席情報入力機能を利用して座席情報を得る
            Seat seat = InputController.inputSeatInfo();

            // 座席予約機能を実行する
            SeatsManager.reserveSeat(seatNum, seat);

            // 予約完了メッセージを出力する
            System.out.println(Constant.RESERVED_MSG);

            // 例外が発生した場合
        } catch (Exception e) {
            // エラーメッセージを出力する
            System.out.println(Constant.SYSTEM_ERROR_MSG);
            System.out.println(Constant.SYSTEM_END_MSG);
        }
    }
}
