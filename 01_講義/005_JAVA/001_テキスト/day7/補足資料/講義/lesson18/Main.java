package java_sample.lesson18;

public class Main {
	public static void main(String[] args) {
//		System.out.println("★学生は合計" + Student.sum + "人です。");
		
		Student student1 = new Student(1, "まなみ", "女性", 19);
		student1.show();
//		System.out.println("★学生は合計" + Student.sum + "人です。");
//		Student.showSum();
		Student student2 = new Student(2, "けんた", "男", 22);
		student2.show();
//		System.out.println("★学生は合計" + Student.sum + "人です。");
	}
}
