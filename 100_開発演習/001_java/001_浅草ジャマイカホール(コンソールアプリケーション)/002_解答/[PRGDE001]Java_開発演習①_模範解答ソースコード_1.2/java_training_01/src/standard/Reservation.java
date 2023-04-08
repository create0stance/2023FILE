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

        // 座席情報(30席)trueの場合は予約済み
        boolean[] seatArray = new boolean[30];

        // 実行確認用に15番と21番を予約済みにしておく
        seatArray[14] = true;
        seatArray[20] = true;

        System.out.println("ようこそ浅草ジャマイカホールへ！\n");
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

        // 指定された座席が予約済みであった場合
        if (seatArray[seatNum]) {
            System.out.println("\n※予約済みの座席です。他の座席を選択してください。");

            // 指定された座席がまだ予約されていなかった場合
        } else {
            // 指定された座席を予約済みにする
            seatArray[seatNum] = true;
            System.out.println("\n座席の予約が完了しました。");
        }
    }

}
