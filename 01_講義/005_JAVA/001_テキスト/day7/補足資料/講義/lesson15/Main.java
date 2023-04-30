package java_sample.lesson15;

public class Main {
	public static void main(String[] args) {
		/**
		 * ★アクセス修飾子
		 * クラスメンバへのアクセス制限を行う。
		 * アクセスを制限することで、データの安全性を保つことが出来る。
		 */
		/**
		 * ★カプセル化
		 * ①オブジェクト指向：三大要素の1つ。
		 * ②フィールドへのアクセスを制限することで、データの安全性を保つ。
		 * ③Getter、Setter：privateなフィールドへの値の代入、値の取得を行うためのメソッド。
		 * ④このようなメソッドをアクセサメソッドと呼ぶ。
		 * ⑤アクセサメソッドは命名にルールがある。
		 * 		値のセット：setFieldname()
		 * 		値の取得：getFieldname()
		 * ※形式化している事も多いが、フレームワーク等ではgetter、setterが実装されていることが前提の場合も多い。
		 */
		Phone phone = new Phone();
		phone.fee = -100;
		
		
	}
}
