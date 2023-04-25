package java_sample.lesson08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sample0808 {
	public static void main(String[] args) throws IOException {
		System.out.println("整数を入力してください。");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
//		String str = reader.readLine();
//		int num = Integer.parseInt(str);
//		
//		if(4 < num && num <= 10) {
//			// numが4より大きい　かつ　numが10以下の場合
//			System.out.println(num + "は4より大きく10以下の数字です。");
//		}else if(num <= 4) {
//			// num が4以下の場合
//			System.out.println(num + "は4以下の数字です。");
//		}else {
//			// それ以外
//			System.out.println(num + "は10より大きい数字です。");
//		}
		
		// 性別
		String gender = "男性";
		// 年齢
		int age = 20;
		// 会員フラグ
		boolean isActive = true;
		
		if(gender ==  "女性" || age == 20) {
			System.out.println("性別:" + gender);
			System.out.println("年齢:" + age);
			System.out.println("女性&新成人キャンペーンをご利用いただけます。");
		}else {
			System.out.println("現在、ご利用頂けるキャンペーンはありません。");
		}
		
		// 女性
		gender = "女性";
		// 非会員
		isActive = false;
		age = 40;
		
		if(gender ==  "女性" || age == 20 && isActive) {
			System.out.println("性別:" + gender);
			System.out.println("年齢:" + age);
			System.out.println("【会員限定】女性&新成人キャンペーンをご利用いただけます。");
		}else {
			System.out.println("現在、ご利用頂けるキャンペーンはありません。");
		}
		
		gender.length();
		
		// 性別を空にする
//		gender = null;
		
//		if(gender.length() == 2 && gender != null) {
//			System.out.println("性別は2文字で設定されています。");
//		}
		
		// 条件演算子(三項演算子)
		// 条件がtrueの場合、? の後の値となる。
		// falseの場合、:の後の値となる。
		gender = "女性";
		age = 21;
		isActive = true;
		String campaign = (gender ==  "女性" || age == 20) && isActive ? "【会員限定】女性&新成人キャンペーン" : null;
		System.out.println(campaign);
		
		if(((gender ==  "女性" || age == 20) && isActive ? "【会員限定】女性&新成人キャンペーン" : null) != null) {
			System.out.println("キャンペーンが利用いただけます。");
		}
	}

}
