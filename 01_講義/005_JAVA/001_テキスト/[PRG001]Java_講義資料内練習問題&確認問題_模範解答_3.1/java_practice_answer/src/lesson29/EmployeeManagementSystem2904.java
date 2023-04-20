package lesson29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 社員管理クラス
 */
public class EmployeeManagementSystem2904 implements ManagementSystem2904 {
    /** 社員名の保存用リスト */
    private List<String> employeeNames = new ArrayList<>();

    /**
     * 社員名の登録
     */
    public void registName() {
        employeeNames.add("田中");
        employeeNames.add("鈴木");
        employeeNames.add("佐藤");
        employeeNames.add("村田");
        employeeNames.add("渡辺");
    }

    /**
     * IDを検索
     *
     * @return ID
     */
    public int inputId() {
        System.out.println("検索したい社員のIDを入力してください。（IDは0～4までの番号を入力してください）");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String idStr = null;

        try {
            idStr = reader.readLine();
        } catch(IOException e) {
            System.out.println("入力処理に失敗しました。");
        }

        // 整数の0-4を正規表現で定義
        Pattern p = Pattern.compile("^[0-4]$");
        // Matcherオブジェクトを作成
        Matcher m = p.matcher(idStr);

        int id = -1;
        if (m.find()) {
            // true(チェックがOK)なら文字列をint型に変換
            id = Integer.parseInt(idStr);
        } else {
            // false(チェックがNG)ならメッセージを表示
            System.out.println("0～4の番号以外の値が入力されました。");
        }

        return id;
    }

    /**
     * 社員名を検索
     *
     * @param id 検索用ID
     */
    public void showName(int id) {
        System.out.println(id + "番の社員の名前は" +employeeNames.get(id) + "です。");
    }
}

