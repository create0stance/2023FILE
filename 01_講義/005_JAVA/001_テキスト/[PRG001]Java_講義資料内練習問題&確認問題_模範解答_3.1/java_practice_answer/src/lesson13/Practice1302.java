package lesson13;

public class Practice1302 {
    public static void main(String[] args) {
        Employee1302 emp;

        // 社員クラスオブジェクトを作成
        emp = new Employee1302();

        // 社員IDの値を入れる
        emp.id = 1111;

        // 社員名の値を入れる
        emp.name = "田中太郎";

        // 社員IDを出力する
        System.out.println("社員ID：" + emp.id);

        // 社員名を出力する
        System.out.println("社員名：" + emp.name);
    }
}
