package question10;

public class Question10_10 {
	public static void main(String[] args) {
		for (int i = 1; i <= 8; i++) {
			for (int j = 8; j > i; j--) {
				System.out.print("　");
			}

			for (int j = 1; j <= 2 * i - 1; j++) {
				if (i % 2 == 0) {
					System.out.print("□");
				} else {
					System.out.print("■");
				}
			}

			System.out.print("\n");
		}
	}
}
