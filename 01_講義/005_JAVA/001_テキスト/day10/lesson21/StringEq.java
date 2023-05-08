package java_sample.lesson21;

public class StringEq {
	
	private final static String path = "-----------------------------------------";
	
	public static void main(String[] args) {

		String str1 = "test";
//		String str2 = "test";
		String str2 = new String("test");

		// 文字列を扱うクラスStringBuilderを生成。文字列加工が得意。
		StringBuilder sb = new StringBuilder(str1);
		String str3 = sb.toString();
		
		Object obj = sb;
		sb.equals(str3);

		System.out.println("str1:" + str1 + "=" + System.identityHashCode(str1));
		System.out.println("str2:" + str2 + "=" + System.identityHashCode(str2));
		System.out.println("str3:" + str3 + "=" + System.identityHashCode(str3));

		System.out.println(path);
		
		//==(等値比較)での比較
		System.out.println("str1==str2での比較結果:" + (str1 == str2));
		//equals()(等価比較)での比較
		System.out.println("str1.equals(str2)での比較結果:" + str1.equals(str2));
		//==(等値比較)での比較
		System.out.println("str1==str3での比較結果:" + (str1 == str3));
		//equals()(等価比較)での比較
		System.out.println("str1.equals(str3)での比較結果:" + str1.equals(str3));

		
		// Integer等の基本型ラッパークラスも同じ
		System.out.println(path);
//		Integer i1 = 1;
//		Integer i2 = new Integer(1);
//		Integer i3 = Integer.valueOf("1");
		
		Character i1 = 'A';
		Character i2 = new Character('A');
		Character i3 = Character.valueOf('A');

		System.out.println("i1:" + i1 + "=" + System.identityHashCode(i1));
		System.out.println("i2:" + i2 + "=" + System.identityHashCode(i2));
		System.out.println("i3:" + i3 + "=" + System.identityHashCode(i3));

		System.out.println("i1==i2での比較結果:" + (i1 == i2));
		System.out.println("i1.equals(i2)での比較結果:" + i1.equals(i2));

		//		testStringClass();
	}

	/**
	 * 文字列を扱うクラスのテスト
	 * 
	 */
	static void testStringClass() {

		long start1 = System.currentTimeMillis();
		doString();
		long time1 = System.currentTimeMillis() - start1;
		System.out.println("String処理時間： " + time1 + " ミリ秒");

		long start3 = System.currentTimeMillis();
		doStringBuilder();
		long time3 = System.currentTimeMillis() - start3;
		System.out.println("StringBuilder処理時間： " + time3 + " ミリ秒");
	}

	static int concatNum = 20000;

	/**
	 * Stringで文字列連結
	 * メモリ消費量が少ない！
	 * 変更が頻繁でない文字列はString！
	 */
	static void doString() {
		String str = new String("");
		for (int i = 0; i < concatNum; i++) {
			str = str.concat("A");
		}
	}

	/**
	 * StringBuilderで文字列連結
	 *	文字の加工が得意！
	 */
	static void doStringBuilder() {
		StringBuilder strbl = new StringBuilder("");
		for (int i = 0; i < concatNum; i++) {
			strbl.append("A");
		}
	}
}
