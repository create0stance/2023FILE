package java_sample.lesson09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sample0908 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		boolean doLoop = true;
		String inputNumber ;
		int loopCounter = 0;
		while(doLoop) {
			loopCounter++;
			System.out.println(loopCounter + "回目の入力です。");
			System.out.println(inputNumber = reader.readLine());
			if(Integer.parseInt(inputNumber) == 0) {
				doLoop = false;
			}
		}
		System.out.println("システムが終了しました。");
	}

}
