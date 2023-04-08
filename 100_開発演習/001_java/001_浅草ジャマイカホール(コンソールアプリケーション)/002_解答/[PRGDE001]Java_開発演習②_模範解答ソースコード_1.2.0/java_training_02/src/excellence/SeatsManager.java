package excellence;

import java.util.ArrayList;
import java.util.List;

/**
 * 座席情報管理クラス
 *
 * @version 2.0
 * @author System Shared
 */
public class SeatsManager {
	// 座席情報
	public static final List<Seat> seats = new ArrayList<Seat>();

	/**
	 * 座席情報初期化
	 */
	public static void init() {
		// 座席情報（空席）を指定された座席分用意する
		for (int i = 0; i < Constant.SEAT_NUM_MAX; i++) {
			seats.add(new Seat());
		}
		
		// 実行確認用に座席情報を用意
		Seat seat1 = new Seat();
		seat1.setName("テスト太郎");
		seat1.setReserved(true);

		// 実行確認用に座席情報を用意
		Seat seat2 = new Seat();
		seat2.setName("テスト花子");
		seat2.setReserved(true);

		// 15番と21番を予約済みにしておく
		seats.set(14, seat1);
		seats.set(20, seat2);
	}

	/**
	 * 空席確認機能
	 *
	 * @param seatNum 座席番号
	 * @return 予約可否(true:予約可 false:予約不可)
	 */
	public static boolean checkVacantSeat(int seatNum) {
		// 予約可否情報格納用
		boolean canReserve = false;

		// 指定された座席が予約済みであった場合
		if (seats.get(seatNum).isReserved()) {
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
	 * 座席予約機能
	 *
	 * @param seatNum 座席番号
	 */
	public static void reserveSeat(int seatNum, Seat seat) {
		// 指定された座席を予約済みにする
		seats.set(seatNum, seat);
	}
}
