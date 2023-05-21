package jp.co.sss.shop.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.ui.Model;

public class Util {
	/**
	 * リクエストスコープ（Model）に保存されているオブジェクトを一覧表示
	 * @param model Model
	 * @return LinkedHashMap
	 */
	public static Map<String, Object> showModelInfoAndReturnMap(Model model) {

		if (model == null) {
			return null;
		}
		
		System.out.println("----------------------------------");
		// リクエストスコープに保存されているMap(LinkedHashMap)の取得
		Map<String, Object> modelMap = model.asMap();
		//Modelの実装クラス名を取得
		System.out.println(model.getClass().getName());

		// Mapをループ処理しキーと値をコンソール出力
		for (Entry<String, Object> entry : modelMap.entrySet()) {
			System.out.println("key:" + entry.getKey());
			System.out.println(entry.getValue());
		}
		System.out.println("----------------------------------");
		return modelMap;
	}
	
	/**
	 * objectをシリアライズ、デシリアライズする
	 * ※試す場合は、対象クラスをimplements Serializableしてください。 
	 * @param object シリアライズ、デシリアライズ対象
	 * @param isDeserialize デシリアライズする場合、true
	 * @return 
	 */
	public static Object serializer(Object obj, boolean isDeserialize) {
		// バイトコードを保存するファイル
		String fileName = "loginForm.txt";
		
		// デシリアライズ処理
		if(isDeserialize) {
			try {
				Object formDe = deSerialize(fileName);
				System.out.println("デシリアライズ後");
				System.out.println(formDe);
				System.out.println("----------------------------");
				return formDe;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// シリアライズ処理
		try {
			serialize(obj, fileName);
			System.out.println(obj + "をシリアライズしました。");
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		return obj;
	}

	/**
	 * LoginFormをシリアライズ（バイトコードで直列化）する
	 * @param form LoginForm
	 * @param fileName ファイルパス
	 * @throws IOException 
	 */
	private static void serialize(Object form, String fileName) throws IOException {

		// ファイルを指定して、FileOutputStreamを生成
		FileOutputStream fileOutputStream = new FileOutputStream(fileName);
		System.out.println(fileName);
		System.out.println(fileOutputStream);
		// OutputStreamに基本データ型とオブジェクトのグラフをOutputStreamに書き込む
		// 今回は、FileOutputStreamに書き込む
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

		// 特定のクラスのオブジェクトの状態をストリームに書き込む
		objectOutputStream.writeObject(form);
		objectOutputStream.flush();
		objectOutputStream.close();
	}

	/**
	 * シリアライズされたLoginFormをデシリアライズする。
	 * @param fileName シリアライズされたバイトコードが記載されているファイルパス
	 * @return デシリアライズされたLoginForm
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private static Object deSerialize(String fileName) throws IOException, ClassNotFoundException {
		// わかりやすくするために冗長に書いている
		// ファイルを指定して、FileInputStreamを生成
		FileInputStream fileInputStream = new FileInputStream(fileName);
		// 事前にObjectOutputStreamを使って作成されたプリミティブ・データとプリミティブ・オブジェクトを直列化復元する
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

		// 対応するwriteObjectメソッドによってストリームに書き込まれたデータを使用する特定のクラスのオブジェクトの状態を読み込み、復元する
		Object form = objectInputStream.readObject();

		objectInputStream.close();

		return form;
	}

}
