package enhancement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * コンサートホール座席予約クラス
 *
 * @version 1.1
 * @author System Shared
 */
public class Reservation {

    /**
     * メイン
     */
    public static void main(String[] args) throws IOException {

        // 座席情報(30席)trueの場合は予約済み
        boolean[] seatArray = new boolean[30];

        // 実行確認用に座席を予約済みにする処理（※満席）
//        for (int i = 0; i < seatArray.length; i++) {
//            seatArray[i] = true;
//        }

        // 実行確認用に座席を予約済みにする処理（※残席15席以下）
        for (int i = 0; i < seatArray.length; i++) {
            // 座席の半数を予約済みにする
            if (i % 2 == 0) {
                seatArray[i] = true;
            }
        }
        // 上記の処理で座席の半数が予約済みになるため+1席分予約済みにして16席
        seatArray[1] = true;

        // 実行確認用に座席を予約済みにする処理（※残席16席以上）
//        for (int i = 0; i < seatArray.length; i++) {
//            if (i % 3 == 0) {
//                seatArray[i] = true;
//            }
//        }

        System.out.println("ようこそ浅草ジャマイカホールへ！\n");

        // 予約済みの席数カウント用
        int reservedSeats = 0;

        // 全席について予約状況を確認する
        for (int i = 0; i < seatArray.length; i++) {
            // その席が予約済みであれば
            if (seatArray[i]) {
                // 予約済みの席数カウントに+1
                reservedSeats++;
            }
        }

        // 完売していた時の表示処理
        if (reservedSeats == 30) {
            System.out.println("完売しています。\n");

            // 残り15席未満だった場合(予約済みの席数が16以上の場合)の表示処理
        } else if (reservedSeats > 15) {
            System.out.println("残りあと数席です。\n");

            // 残り16席以上だった場合の表示処理
        } else {
            System.out.println("まだ余裕があります。\n");
        }

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
