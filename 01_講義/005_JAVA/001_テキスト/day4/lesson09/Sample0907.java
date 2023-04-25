package java_sample.lesson09;

public class Sample0907 {
	public static void main(String[] args) {
		for(int i = 1; i <= 9; i++) {
			System.out.print(i);
			for (int j = 1; j <= 9; j++) {
				System.out.print("*");
				System.out.print(j);
				System.out.print("|");
				
			}
			System.out.println();
		}
	}
}
