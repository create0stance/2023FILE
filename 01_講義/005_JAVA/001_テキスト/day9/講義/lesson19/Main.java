package java_sample.lesson19;

public class Main {
	public static void main(String[] args) {
		// Java Development Kit（ジャヴァ・デベロップメント・キット）：
		// Javaでのソフトウェア開発キット
		
//		Stringクラスのメソッド
		String str = "GWは楽しめましたか？";
		
		//引数の文字が最初に出現する位置を返す
		int n = str.indexOf((int)'？');
		n = str.indexOf("？");
		System.out.println(n);
		
		//引数の位置から最後までの部分文字列を返す
		String sub = str.substring(3);
		System.out.println(sub);
		
		// 文字列の連結
		System.out.println(str.concat(sub));
		
		// 文字列の置き換え
		System.out.println(str.replace("GW","年末"));
		
//		String eq1 = "山";
//		String eq2 = "山";
		String eq1 = new String("山");
		String eq2 = "山";
		// 等値比較
		System.out.println(eq1 == eq2);
		// 等価比較
		System.out.println(eq1.equals(eq2));
		
		// 朝1：復習
		// 朝2：クラスライブラリ：午前中
		// 午後：継承：講義
		// 今日重い
	}
}
