package lesson29;

public class Practice2903 {
    public static void main(String[] args) {
    	// 携帯電話クラスのオブジェクトを生成
        SmartPhone2903 smartPhone = new SmartPhone2903("test@its.com");

        // 携帯電話の情報を表示
        smartPhone.showInformation();

        // 電話を掛ける
        smartPhone.call();
    }
}
