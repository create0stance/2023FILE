package review;

/**
 * 計算クラス
 *
 */
public class Calc {
	/** 名称 */
	String name ;
	
	/** バージョン情報 */
	double versionNumber;
	
	/**
	 * 引数で受け取った文字列1,2を連結しコンソールに出力
	 * @param str1 文字列1
	 * @param str2 文字列2
	 */
	void concatText(String str1,String str2) {
		System.out.println(str1 + str2);
	}
	/**
	 * バージョンを0.1アップし、取得
	 * @return バージョン情報
	 */
	double updateAndGetVerison() {
		versionNumber += 0.1;
		return versionNumber;
	}
	
	/**
	 * 台形の面積を計算しコンソール出力する
	 * @param topLine 上底
	 * @param underLine 下底
	 * @param height 高さ
	 */
	void trapezoid(int topLine, int underLine, int height) {

		// 面積を計算し、resultに代入
		int result = (topLine + underLine) * height / 2;

		// 出力文章の作成
		String info = "上底" + topLine + "cm下底" + underLine + "cm高さ" + height + "cmの台形の面積は";
		info += result + "cm2です。";

		// コンソールに出力
		System.out.println(info);
	}

	/**
	 * 税込み価格を取得
	 * @param itemPrice 商品価格
	 * @return 税込み価格
	 */
	int inTax(int itemPrice) {
		// 消費税率
		double taxRate = 0.1;
		return (int) (itemPrice * (1 + taxRate));
	}
	
	/**
	 * 引数で受け取った国番号に対応した国名をリターンする
	 * @param countryNum 国番号
	 * @return 国名 || 不明
	 */
	String getCountryNameWithNum(int countryNum) {
		String[] countryNames = {"日本","アメリカ","中国","韓国","オーストリア"};
		if(countryNum < 0 || countryNum > countryNames.length - 1) {
			return "不明";
		}
		return countryNames[countryNum];
		
		// 【応用】：例外処理利用する
//		String[] countryNames = {"日本","アメリカ","中国","韓国","オーストリア"};
//		try {
//			return countryNames[countryNum];
//		} catch (IndexOutOfBoundsException e) {
//			return "不明";
//		}
	}
	/**
	 * 数値1～数値2までの整数の合計値を取得
	 * @param num1 数値1
	 * @param num2	数値2
	 * @return 合計値
	 */
	long totalValueNum1ToNum2(int num1,int num2) {
		// 合計値
		long totalValue = 0l;
		// 最小値
		int min;
		// 最大値
		int max;
		
		// 数値の大小比較
		if(num1 <= num2) {
			min = num1;
			max = num2;
		}else {
			min = num2;
			max = num1;
		}
	
		for(int i = min; i <= max; i++) {
			totalValue += i;
		}
		return totalValue;
		
		// Mathクラスを使う方法もあるよ
//		int sum = 0;
//		int count = Math.abs(num1 - num2) + 1;
//		int min = Math.min(num1, num2);
//		for(int i = min; i < min + count ; i++) {
//			sum += i;
//		}
//		return sum;
	}
}
