package excellence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 入力制御クラス
 *
 * @version 2.0
 * @author System Shared
 */
public class InputController {

    /**
     * 座席番号入力機能
     *
     * @return 座席番号
     * @throws IOException 入出力例外
     */
    public static int inputSeatNum() throws IOException {

        System.out.println(Constant.INPUT_SEAT_NUM_MSG);
        System.out.print("＞");

        // 入力準備
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 座席番号の入力処理
        String seatNumStr = br.readLine();

        // 座席番号を数値に変換
        int seatNum = Integer.parseInt(seatNumStr);

        // 入力値が0～29ではなく1～30なので-1で補正する
        seatNum--;

        return seatNum;
    }

    /**
     * 座席情報入力機能
     *
     * @return 座席情報
     * @throws IOException 入出力例外
     */
    public static Seat inputSeatInfo() throws IOException {
        // 入力準備
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 名前の入力処理
        System.out.println(Constant.INPUT_USER_NAME_MSG);
        System.out.print("＞");
        String name = br.readLine();

        // 座席情報作成
        Seat seat = new Seat();

        // 入力された名前を入れる
        seat.setName(name);

        // この座席を予約済みにする
        seat.setReserved(true);

        return seat;
    }
}
