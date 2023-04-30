package java_sample.lesson18;

public class Student {	
	private static final String PATH = "===============================\n";
	/** 
	 * ★static変数：
	 * オブジェクト固有の情報を持たないフィールド
	 * オブジェクトを生成せずに利用できる。
	 * アクセス：クラス名.フィールド名
	 *  */
	static int sum = 0;
	
	/**
	 * ★インスタンス変数：
	 * オブジェクト固有の情報を持つ
	 * newしオブジェクト生成後、アクセスできる
	 */
	/** 生徒番号 */
	private int no ;
	/** 生徒名 */
	private String name;
	/** 性別 */
	private String gender;
	/** 年齢 */
	private int age;
	
	
	/**
	 * コンストラクタ
	 * @param no 生徒番号
	 * @param name 名前
	 * @param gender 性別
	 * @param age 年齢
	 */
	public Student(int no,String name,String gender,int age) {
		this.no = no;
		this.name = name;
		this.gender = gender;
		this.age = age;
		System.out.println(Student.PATH + "学生を作成しました。");
		// 1加算する
		sum++;
	}
	
	/**
	 * インスタンスメソッド
	 * オブジェクト固有の処理に関するメソッド
	 */
	public void show() {
		System.out.println("学生番号は" + no + "番です。");
		System.out.println("名前は" + name + "です。");
		System.out.println("性別は" + gender + "です。");
		System.out.println("年齢は" + age + "歳です。");
		showSum();
	}
	
	/** staticメソッド */
	public static void  showSum() {
		System.out.println("★学生は合計" + sum + "人です。");
	}
	
}
