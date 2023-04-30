package java_sample.lesson17;

public class Dog {
	String line = "===========================\n";
	
	/** 雌雄 */
	private String gender;
	
	/** 犬種 */
	private String breed;
	
	/**
	 * コンストラクタ：
	 * オブジェクト生成時に実行される
	 */
	public Dog() {
		System.out.println(line+"1:コンストラクタ内の処理が実行されました");
		gender = "未設定";
		breed = "未設定";
	}
	/**
	 * 引数を持つコンストラクタ
	 * オブジェクト生成時に引数を渡すと実行される。
	 * ★生成と同時にフィールドに値をセットできる
	 */
	public Dog(String gender) {
		this();
		System.out.println(line+"2:引数ありのコンストラクタが実行されました");
		this.gender = gender;
	}
	
	/** 情報を表示する */
	public void show() {
		System.out.println("性別は" + this.gender + "です。");
		System.out.println("犬種は" + this.breed + "です。");
	}
	
	
	/**
	 * 雌雄を取得
	 * @return gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * 犬種を取得
	 * @return breed
	 */
	public String getBreed() {
		return breed;
	}
	/**
	 * 雌雄をセットする
	 * @param gender セットする雌雄
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * 犬種をセットする
	 * @param breed セットする犬種
	 */
	public void setBreed(String breed) {
		this.breed = breed;
	}
}
