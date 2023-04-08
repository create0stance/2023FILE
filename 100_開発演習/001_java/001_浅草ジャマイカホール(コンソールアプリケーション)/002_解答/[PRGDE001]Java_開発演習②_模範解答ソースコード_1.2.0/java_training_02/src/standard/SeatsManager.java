package standard;

/**
 * 座席情報管理クラス
 *
 * @version 1.0
 * @author System Shared
 */
public class SeatsManager {
    // 座席情報(30席)trueの場合は予約済み
    public static final boolean[] seatArray = new boolean[30];

    /**
     * 空席確認機能
     *
     * @param seatNum 座席番号
     * @return 予約可否(true:予約可 false:予約不可)
     */
    public static boolean checkVacantSeat(int seatNum) {
        // 実行確認用に15番と21番を予約済みにしておく
        seatArray[14] = true;
        seatArray[20] = true;

        // 予約可否情報格納用
        boolean canReserve = false;

        // 指定された座席が予約済みであった場合
        if (seatArray[seatNum]) {
            // 予約不可とする
            canReserve = false;

            // 指定された座席がまだ予約されていなかった場合
        } else {
            // 予約可とする
            canReserve = true;
        }

        return canReserve;
    }

    /**
     *座席予約機能
     *
     * @param seatNum 座席番号
     */
    public static void reserveSeat(int seatNum) {
        // 指定された座席を予約済みにする
        seatArray[seatNum] = true;
    }
}
