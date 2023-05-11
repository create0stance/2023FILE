package jp.co.sss.shop.form;

/**
 * フォームデータを保持するクラス
 *
 */
public class LoginForm {
	/** userId */
	private Integer userId;
	
	/** パスワード */
	private String password;
	/**
	 * @return userId
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param userId セットする userId
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @param password セットする password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	
	
}
