package enhancement;

/**
 * システムメインクラス
 *
 * @version 1.1
 * @author System Shared
 */
public class SystemMain {

    /**
     * メイン
     */
    public static void main(String[] args) {

        System.out.println("ようこそ浅草ジャマイカホールへ！\n");

        try {
            // 座席番号確認用
            int seatNum = 0;

            // 予約可否情報格納用
            boolean canReserve = false;

            do {
                // 座席番号入力機能を利用して座席番号を得る
                seatNum = InputController.inputSeatNum();

                // 空席確認機能を利用して入力された座席が空席か調べる
                canReserve = SeatsManager.checkVacantSeat(seatNum);

                // 指定された座席が予約済みであった場合
                if (!canReserve) {
                    System.out.println("\n※予約済みの座席です。他の座席を選択してください。\n");
                }
                // 指定された座席が予約済みの座席である場合入力ををやり直す
            } while (!canReserve);

            // 座席予約機能を実行する
            SeatsManager.reserveSeat(seatNum);
            System.out.println("\n座席の予約が完了しました。");

            // 例外が発生した場合
        } catch (Exception e) {
            // エラーメッセージを出力する
            System.out.println("システムエラーが発生しました。");
            System.out.println("システムを終了します。");
        }
    }
}
