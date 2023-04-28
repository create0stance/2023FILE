package question10;

public class Question10_06 {
	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			if (i == 5) {
				continue;
			}
			System.out.println(i + "回目の処理です");
		}

		System.out.println("処理を終了します");
	}
}