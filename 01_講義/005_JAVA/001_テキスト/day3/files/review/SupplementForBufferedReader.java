package review;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * BufferedReader補足用クラス
 */
public class SupplementForBufferedReader {

	private static String line = "=============================";

	public static void main(String[] args) throws IOException {
		// メニュー表示
		showMenu();
		
//		//InputStreamを使う
//		useInputStream();
//		
//		//InputStreamReaderを使う
//		useInputStreamReader();
//		
//		// Bufferedreaderを使う
//		useBufferedReader();
//		
//		// BufferedReaderでtxtファイル読み込み
//		loadFileBufferedReader();

	}

	/**
	 * InputStreamクラスで文字列を取得
	 * @throws IOException
	 */
	private static void useInputStream() throws IOException {
		System.out.print("InputStreamで文字列を取得します。文字列を入力してください。\n> ");
		/*
		 * InputStream:
		 *	・入力された文字列を1バイトの連続したバイトコードとして読み込む
		 */
		// InputStreamをSystemクラスから取得
		InputStream in = System.in;
		int byteCode;

		// 入力文字列を1バイトずつ取得し10進数で取得
		while ((byteCode = in.read()) != -1) {
			// バイトコードを出力
			System.out.println("バイトコード：" + byteCode);
			// バイトコードをcharに変換すると、アスキーコードに対応した1文字に変換される。
			System.out.println("文字へ変換：" + (char) byteCode);
			// ※日本語等は、1文字2バイトなので正しく取得できない
		}

	}

	/**
	 * InputStreamReaderで文字列データを取得
	 * @throws IOException
	 */
	private static void useInputStreamReader() throws IOException {
		System.out.print("InputStreamReaderを使用し文字列を取得します。文字列を入力してください。\n> ");
		/*
		 * InputStreamReader：
		 * バイトストリームを読み込み文字ストリームへ変換する。
		 * バイトストリーム：1バイトごとの連続したデータ
		 * 文字ストリーム：1文字ごとの連続したデータ
		 */
		// InputStreamReaderオブジェクトを生成
		InputStreamReader streamReader = new InputStreamReader(System.in);

		int aschiiCode;
		// 文字列データを1文字ずつ文字コードで取得
		while ((aschiiCode = streamReader.read()) != 13) {
			System.out.println("文字コード：" + aschiiCode);
			// 文字コードをcharに変換すると、アスキーコードに対応した1文字に変換される。
			System.out.println("文字へ変換：" + (char) aschiiCode);
		}
	}

	/**
	 * BufferedReaderで文字列を読み込む
	 * @throws IOException
	 */
	private static void useBufferedReader() throws IOException {
		
		System.out.print("BufferedReaderを使用し文字列を取得します。文字列を入力してください。\n> ");

		// InputStreamオブジェクトを取得：バイトストリームで入力された文字列を取得。
		InputStream in = System.in;

		// InputStreamReaderオブジェクトを生成：バイトストリームを文字ストリームへ変換。
		InputStreamReader streamReader = new InputStreamReader(in);

		// BufferedReaderオブジェクトを生成：文字ストリームから、効率的に文字をまとめて読み込む
		// 効率的=>バッファと呼ばれる領域に読み込んだデータを保持し（buffering）、そこから読み込みを行っている
		BufferedReader reader = new BufferedReader(streamReader);

		// BufferedReaderのreadlineメソッドを利用し、入力された文字列を読み込み変数strに代入
		// ※改行コードが入力されるまで、処理がストップする
		// ※例外IOExceptionが発生する可能性のあるメソッドのため例外処理が必要
		String str = reader.readLine();

		System.out.println("入力された文字列：" + str);

	}

	private static long startTime;
	private static long endTime;

	static void loadCsv() throws IOException {

		// 計測開始
		startTime = System.nanoTime();
		loadFileBufferedReader();
		// おまけのおまけ：scannerでファイル読み込み：実行時間の違いをチェックできるよ。
		//	loadFileScanner();

		// 計測終了
		endTime = System.nanoTime();

		// 実行時間をミリ秒で表示
		System.out.println("実行時間:" + (double) (endTime - startTime) / 1000000 + "ミリ秒");
	}

	/**
	 * CSVをBufferedReaderで処理する
	 * @throws IOException
	 */
	static void loadFileBufferedReader() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("hokkaido_animals.txt")));
		// 1行の文字列を代入する変数
		String line;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}
	}

	/**
	 * CSVをScannerで処理する
	 * @throws FileNotFoundException
	 */
	static void loadFileScanner() throws FileNotFoundException {

		Scanner scanner = new Scanner(new File("hokkaido_animals.txt"));
		while (scanner.hasNext()) {
			String line = scanner.nextLine();
			System.out.println(line);
		}
	}

	/**
	 * メニュー表示
	 * @throws IOException
	 */
	static void showMenu() throws IOException {
		// メニュー表示
		System.out.println("1:InputStreamで文字列を扱う");
		System.out.println("2:InputStreamReaderで文字列を扱う");
		System.out.println("3:BufferedReaderで文字列を扱う");
		System.out.println("4:[おまけ]txtファイルをBufferedReaderで扱う");
		System.out.println(line);
		System.out.print("メニュー番号を入力してください。(1～4)\n> ");

		// InputStreamの取得
		InputStream in = System.in;

		// 1byte読み込む
		int selectNum = in.read();
		// データ破棄
		in.skip(in.available());
		// バイトコードを文字に変換
		char selectChar = (char) selectNum;

		switch (selectChar) {
		case '1': {
			useInputStream();
			break;
		}
		case '2': {
			useInputStreamReader();
			break;
		}
		case '3': {
			useBufferedReader();
			break;
		}
		case '4': {
			loadCsv();
			break;
		}
		default:
			System.out.println("1～4の数値を入力してください。");
		}
	}
}
