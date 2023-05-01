package review_obj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Oparator {
	String[][] getAnimalsArray() {
		String[][] animalsArray = new String[20][6];
		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(new FileInputStream("hokkaido_animals.txt")))) {
			// 1行の文字列を代入する変数
			String line;
			for (int i = 0; (line = reader.readLine()) != null; i++) {
				animalsArray[i] = line.split(",");
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return animalsArray;
	}
}
