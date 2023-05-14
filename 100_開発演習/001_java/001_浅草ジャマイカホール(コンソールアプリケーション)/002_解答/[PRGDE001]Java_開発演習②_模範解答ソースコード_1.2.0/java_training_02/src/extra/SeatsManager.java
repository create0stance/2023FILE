package extra;

import java.util.ArrayList;
import java.util.List;

/**
 * 座席情報管理クラス
 *
 * @version 3.0
 * @author System Shared
 */
public class SeatsManager {
    // 全座席情報
    public static final List<Seat> seats = new ArrayList<Seat>();

    /**
     * 座席情報初期化
     */
    public static void init() {
     // 座席情報（空席）を指定された座席分用意する
        for (int i = 0; i < Constant.SEAT_NUM_MAX; i++) {
            User user = new User();
            Seat seat = new Seat();
            //以下はテスト用の性別設定
            if(i%3 == 0){
                user.setGender(2);
            } else {
                user.setGender(1);
            }
            seat.setUser(user);
            //以下はテスト用の予約済み設定
            if (i == 0){
                seat.setReserved(true);
            } else if(i%2 == 0){
                seat.setReserved(true);
            } else if(i == 29){
                seat.setReserved(true);
            }

            seats.add(seat);
        }
        int j= 0;
        for(Seat seat:seats) {
//        	System.out.print(++j);
//        	System.out.print(":");
        	String gender = "";
        	String s = "空席";
        	if(seat.isReserved()) {
        		s = "予約済";
        		if(seat.getUser().getGender() == 1) {
        			gender = "男性";
        		}
        		if(seat.getUser().getGender() == 2) {
        	
        			gender = "女性";
        		}
        	}
//        	System.out.print(s);
//        	System.out.print(":");
//        	System.out.print(gender);
//        	System.out.print("|");
        }
    }

    /**
     * 座席自動予約機能
     *
     * @param user ユーザー情報
     */
    public static boolean reserveSeat(User user) {

        boolean isReserved = false;

        // 座席番号選択機能を利用し予約可能な座席番号を取得する
        int seatNum = AutoSelectLogic.selectSeatNum(user, seats);

        // 予約可能な座席番号が取得できた場合
        if (seatNum != Constant.NO_VACANT_NUM) {
            // 座席情報を作成する
            Seat seat = new Seat();

            // ユーザー情報を登録する
            seat.setUser(user);

            // 予約済みにする
            seat.setReserved(true);

            //全座席情報に予約した座席の情報を登録する
            seats.set(seatNum, seat);

            // 予約済みフラグを立てる
            isReserved = true;

            System.out.println("予約できた座席は" + (seatNum + 1) + "番です。");

            // 予約可能な座席番号が取得できなかった場合（満席時）
        } else {
            // 満席だった時のメッセージを表示
            System.out.println(Constant.NO_VACANT_MSG);
        }

        return isReserved;
    }
}
