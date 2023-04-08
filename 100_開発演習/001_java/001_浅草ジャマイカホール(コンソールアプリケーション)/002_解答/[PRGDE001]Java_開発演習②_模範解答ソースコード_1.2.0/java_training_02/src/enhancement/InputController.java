package enhancement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 入力制御クラス
 *
 * @version 1.0
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

        System.out.println("何番の座席を予約しますか？（1～30）");
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
}
