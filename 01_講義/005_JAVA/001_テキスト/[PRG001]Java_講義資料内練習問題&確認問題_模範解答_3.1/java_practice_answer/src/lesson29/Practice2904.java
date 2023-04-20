package lesson29;

public class Practice2904 {
    public static void main(String[] args) {
        // 社員管理クラスのオブジェクトを生成
        EmployeeManagementSystem2904 ems = new EmployeeManagementSystem2904();

        // 社員名の登録
        ems.registName();

        // IDを検索
        int id = ems.inputId();

        // 正しいIDの場合のみ社員名を表示
        if (id != -1) {
            ems.showName(id);
        }
    }
}
