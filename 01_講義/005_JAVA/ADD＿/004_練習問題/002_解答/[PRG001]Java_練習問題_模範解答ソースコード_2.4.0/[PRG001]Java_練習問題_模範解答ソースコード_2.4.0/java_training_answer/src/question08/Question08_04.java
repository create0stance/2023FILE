package question08;

public class Question08_04 {
	public static void main(String[] args) {
		int[][] num = new int[2][3];

		num[0][0] = 10;
		num[0][1] = 20;
		num[0][2] = 30;
		num[1][0] = 40;
		num[1][1] = 50;
		num[1][2] = 60;

		System.out.println("1段目の1つ目の値は" + num[0][0]);
		System.out.println("1段目の2つ目の値は" + num[0][1]);
		System.out.println("1段目の3つ目の値は" + num[0][2]);
		System.out.println("2段目の1つ目の値は" + num[1][0]);
		System.out.println("2段目の2つ目の値は" + num[1][1]);
		System.out.println("2段目の3つ目の値は" + num[1][2]);
	}
}
