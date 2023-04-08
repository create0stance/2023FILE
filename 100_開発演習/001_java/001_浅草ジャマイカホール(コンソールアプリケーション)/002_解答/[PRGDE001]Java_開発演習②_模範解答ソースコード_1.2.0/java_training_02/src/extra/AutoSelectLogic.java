package extra;

import java.util.List;

/**
 * 自動座席予約ロジッククラス
 *
 * @version 1.0
 * @author System Shared
 */
public class AutoSelectLogic {

    /**
     * 座席番号選択機能
     *
     * @param user ユーザー情報
     * @param seats 全座席情報
     * @return 座席番号
     */
    public static int selectSeatNum(User user, List<Seat> seats) {

        // 座席番号を空席が見つからなかった時の値で初期化
        int seatNum = Constant.NO_VACANT_NUM;

        // 両側が空いている席がないか確認する
        seatNum = selectBySideVacant(seats);

        // 両側が空いている席がなかった場合
        if (seatNum == Constant.NO_VACANT_NUM) {

            // 両側の席がユーザーと同性である席がないか確認する
            seatNum = selectByGender(user, seats);
        }
        // 両側がユーザーと同性である席がなかった場合
        if (seatNum == Constant.NO_VACANT_NUM) {

            // 条件を付けずに空席があるか確認する
            seatNum = selectByVacant(seats);
        }

        return seatNum;
    }

    /**
     * 両側が空いている座席を選択する
     *
     * @param seats 全座席情報
     * @return 座席番号
     */
    private static int selectBySideVacant(List<Seat> seats) {

        // 座席番号を空席が見つからなかった時の値で初期化
        int seatNum = Constant.NO_VACANT_NUM;

        // 2席目から最後の席の隣まで繰り返す（端の席は考慮しないので）
        for (int i = 1; i < seats.size() - 1; i++) {

            // 空席を発見した場合
            if (!seats.get(i).isReserved()) {

                // その両側の席が空いている場合
                if (!seats.get(i + 1).isReserved()
                        && !seats.get(i - 1).isReserved()) {

                    // その席の番号を予約する席の番号とする
                    seatNum = i;
                    break;
                }
            }
        }

        return seatNum;
    }

    /**
     * 両側の座席の予約者がユーザーの同性である座席を選択する
     *
     * @param user ユーザー情報
     * @param seats 全座席情報
     * @return 座席番号
     */
    private static int selectByGender(User user, List<Seat> seats) {

        // 座席番号を空席が見つからなかった時の値で初期化
        int seatNum = Constant.NO_VACANT_NUM;

        // ユーザーの性別を格納する
        int gender = user.getGender();

        // 2席目から最後の席の隣まで繰り返す（端の席は考慮しないので）
        for (int i = 1; i < seats.size() - 1; i++) {

            // 空席を発見した場合
            if (!seats.get(i).isReserved()) {

                // その両側の席の予約者が同性であった場合
                if ((seats.get(i + 1).getUser().getGender() == gender)
                        && (seats.get(i - 1).getUser().getGender() == gender)) {

                    // その席の番号を予約する席の番号とする
                    seatNum = i;
                    break;
                }
            }
        }

        return seatNum;
    }

    /**
     * 無条件で空席を選択する
     *
     * @param seats 全座席情報
     * @return 座席番号
     */
    private static int selectByVacant(List<Seat> seats) {

        // 座席番号を空席が見つからなかった時の値で初期化
        int seatNum = Constant.NO_VACANT_NUM;

        // 座席の数だけ繰り返す
        for (int i = 0; i < seats.size(); i++) {

            // 空席を発見した場合
            if (!seats.get(i).isReserved()) {

                // その席の番号を予約する席の番号とする
                seatNum = i;
                break;
            }
        }

        return seatNum;
    }
}
