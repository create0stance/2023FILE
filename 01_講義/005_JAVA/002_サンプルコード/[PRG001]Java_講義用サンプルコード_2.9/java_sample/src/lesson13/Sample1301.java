フィールドとは？
オブジェクトの生成の仕方。
生成したオブジェクトの変数への代入。
フィールドへの値の代入。
フィールドからの値の取得。
個々のオブジェクトの情報を保存する変数。

// phoneクラスに以下のフィールドを追加しよう。
・本体価格
int型 / 変数名 price

・機種名
String型 / 変数名 name

priceに148000
nameにiphone14proを代入し、コンソールに出力しよう。

// 2台目の電話オブジェクトを生成しよう
オブジェクトを代入する変数名：phone2
使用料：7000
通信量：3.0
price：54000
name:iphoneSE

package lesson13;

public class Sample1301 {

	public static void main(String[] args) {
		// 携帯電話クラスのオブジェクトを生成
		Phone1301 phone = new Phone1301();

		// フィールドに値を代入
		phone.fee = 5000;
		phone.data = 2.0;

		// フィールドの値を出力
		System.out.println("料金は" + phone.fee + "円です。");
		System.out.println("データ通信量は" + phone.data + "GBです。");
	}
}
