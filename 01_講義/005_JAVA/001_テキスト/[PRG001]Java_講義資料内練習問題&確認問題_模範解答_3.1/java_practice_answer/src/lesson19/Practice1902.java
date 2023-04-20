package lesson19;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Practice1902 {
    public static void main(String[] args) {
    	// 日付を取得する
        Date date = new Date();

        // 書式化文字列を指定する
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        System.out.println("現在時刻は" + sdf.format(date) + "です。");
    }
}