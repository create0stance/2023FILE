package question10;

public class Question10_03 {
	public static void main(String[] args) {
		int i = 1;

		System.out.println("1回目の繰り返し処理です");
		do {
			System.out.println(i + "回目");
			i++;
		} while (i <= 5);

		int n = 1;

		System.out.println("2回目の繰り返し処理です");
		do {
			System.out.println(n + "回目");
			n++;
		} while (n <= 10);

		System.out.println("処理を終了します");
	}
}
