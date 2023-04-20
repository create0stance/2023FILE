package lesson29;

public class Practice2902 {
    public static void main(String[] args) {
        //  Cat2901クラスのオブジェクトを生成する。
        Cat2901 cat = new Cat2901();

        // 名前を設定
        cat.setName("ミケ");
        // 年齢を設定
        cat.setAge(2);
        // 体重を設定
        cat.setWeight(3.6);

        // 猫の情報を表示
        cat.show();
        // 鳴き声を表示
        cat.cry();
        // 睡眠を表示
        cat.sleep();
        // 猫の情報を表示する
        cat.show();
    }
}
