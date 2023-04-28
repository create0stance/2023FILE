package question10;

public class Question10_05 {
	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			System.out.println(i + "回目の処理です");
			if (i == 5) {
			    break;
			}
		}

		System.out.println("処理を終了します");
	}
}
