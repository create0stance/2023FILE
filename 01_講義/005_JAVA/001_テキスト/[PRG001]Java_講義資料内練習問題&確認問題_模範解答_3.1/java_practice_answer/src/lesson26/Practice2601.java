package lesson26;

import java.util.ArrayList;
import java.util.List;

public class Practice2601 {
    public static void main(String[] args) {
        // DVDのタイトルを格納するリストを生成する
        List<String> list = new ArrayList<>();

        // リストにDVDタイトル「Java基礎」を追加する
        list.add("Java基礎");

        // リストにDVDのタイトル「Java応用」を追加する
        list.add("Java応用");

        // リストから「Java応用」を削除する
        list.remove(1);

        // リスト内の要素数を取得して標準出力する
        System.out.println("要素数は" + list.size() + "個です。");
    }
}
