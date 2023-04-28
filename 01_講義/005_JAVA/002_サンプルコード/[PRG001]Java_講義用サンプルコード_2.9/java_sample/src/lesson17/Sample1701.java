package lesson17;

public class Sample1701 {
    public static void main(String[] args) {
    	// 犬クラスのオブジェクトを生成してコンストラクタを呼び出す
        Dog1701 dog = new Dog1701("オス", "柴犬");
        Dog1701 dog2 = new Dog1701();

        // 性別と犬種の値を出力
        dog.show();
        dog2.show();
    }
}
