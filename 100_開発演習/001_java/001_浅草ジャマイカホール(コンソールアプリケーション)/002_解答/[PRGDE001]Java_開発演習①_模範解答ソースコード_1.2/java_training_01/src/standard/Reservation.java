package standard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * コンサートホール座席予約クラス
 *
 * @version 1.0
 * @author System Shared
 */
public class Reservation {

    /**
     * メイン
     */
    public static void main(String[] args) throws IOException {

        boolean[] seatArray = new boolean[30];

        seatArray[14] = true;
        seatArray[20] = true;

        System.out.println("ようこそ浅草ジャマイカホールへ！\n");
        System.out.println("何番の座席を予約しますか？（1～30）");
        System.out.print("＞");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String seatNumStr = br.readLine();

        int seatNum = Integer.parseInt(seatNumStr);

        seatNum--;

        if (seatArray[seatNum]) {
            System.out.println("\n※予約済みの座席です。他の座席を選択してください。");

        } else {
            seatArray[seatNum] = true;
            System.out.println("\n座席の予約が完了しました。");
        }
    }

}
