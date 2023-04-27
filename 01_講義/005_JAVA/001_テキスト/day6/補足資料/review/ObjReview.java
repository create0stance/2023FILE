package review;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

public class ObjReview {
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));		
		// キャラクターオブジェクトを生成し、変数playerに代入しよう。
		Character player = new Character();
		
		// 
		player.name = "ちゃむちゃむ";
		player.gender = 2;
		player.type = 2;
		
		System.out.println("Player「" + player.name + "」を作成しました。");
		System.out.println("性別は「" + player.getGendeWithString() + "」です。");
		System.out.println("属性は「" + player.getTypeWithString() + "」です。");
		
		Date d = new Date();
		System.out.println(d.getSeconds() * 10);
		
//		System.out.print("プレイヤーを作成します。お名前を入力してください。\n> ");
//		player.name = reader.readLine();
//		System.out.println("性別を選択してください。\n1:男性\n2:女性\n3:未選択");
//		player.gender = Integer.parseInt(reader.readLine());
//		System.out.println("属性を選択してください。\n1:一般人\n2:Instagrammer\n3:Twitter");
//		
		
		Item item = new Item();
		item.id = 1;
		item.name = "iPhone14Pro";
		item.atackPower = 148000;
		item.showItem();
		
//		ObjReview objReview = new ObjReview();
//		String[][] animalsArray = objReview.getAnimalsArray();
		
		
	}

	String[][] getAnimalsArray() {
		String[][] animalsArray= new String[20][6];
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("hokkaido_animals.txt")))) {
			// 1行の文字列を代入する変数
			String line;
			for(int i = 0;(line = reader.readLine()) != null;i++) {
				animalsArray[i] = line.split(",");
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return animalsArray;
	}
}
