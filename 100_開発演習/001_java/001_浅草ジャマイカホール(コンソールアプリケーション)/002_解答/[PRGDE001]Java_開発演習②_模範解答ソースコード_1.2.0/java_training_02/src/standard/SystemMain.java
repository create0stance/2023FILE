package standard;

import java.io.IOException;

/**
 * システムメインクラス
 *
 * @version 1.0
 * @author System Shared
 */
public class SystemMain {

    /**
     * メイン
     */
    public static void main(String[] args) throws IOException {

        System.out.println("ようこそ浅草ジャマイカホールへ！\n");

        // 座席番号入力機能を利用して座席番号を得る
        int seatNum = InputController.inputSeatNum();

        // 空席確認機能を利用して入力された座席が空席か調べる
        boolean canReserve = SeatsManager.checkVacantSeat(seatNum);

        // 指定された座席がまだ予約されていなかった場合
        if (canReserve) {
            // 座席予約機能を実行する
            SeatsManager.reserveSeat(seatNum);
            System.out.println("\n座席の予約が完了しました。");

            // 指定された座席が予約済みであった場合
        } else {
            System.out.println("\n※予約済みの座席です。他の座席を選択してください。");
        }
    }
}
