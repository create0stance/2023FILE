package lesson26;

import java.util.HashMap;
import java.util.Map;

public class Practice2602 {
    public static void main(String[] args) {
        // 人名とその人が生まれた年の元号を格納するマップを生成する
        Map<String, String> map = new HashMap<>();

        // mapにキー「田中太郎」、値「昭和」を追加する
        map.put("田中太郎", "昭和");

        // mapにキー「鈴木二郎」、値「平成」を追加する
        map.put("鈴木二郎", "平成");

        // mapにキー「渡辺花子」、値「平成」を追加する
        map.put("渡辺花子", "平成");

        System.out.print("田中太郎さんは");
        // 田中太郎さんが生まれた年の元号を標準出力する
        System.out.println(map.get("田中太郎") + "生まれです。");

        System.out.print("鈴木二郎さんは");
        // 鈴木二郎さんが生まれた年の元号を標準出力する
        System.out.println(map.get("鈴木二郎") + "生まれです。");

        System.out.print("渡辺花子さんは");
        // 渡辺花子さんが生まれた年の元号を標準出力する
        System.out.println(map.get("渡辺花子") + "生まれです。");
    }
}
