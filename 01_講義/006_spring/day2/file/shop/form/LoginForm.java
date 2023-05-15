package jp.co.sss.shop.form;

import java.io.Serializable;

/**
 * フォームデータを保持するクラス
 *
 */
public class LoginForm  implements Serializable {
	
//	public LoginForm(){
//		this.userId = 1;
//		this.password = "12345";
//	}
	
	@Override
	public String toString() {
		return "test1:" + test1 + "userId:" + userId;
	}
	private String test1 = "test111";
	/** userId */
	private Integer userId = 0;
	
	/** userId2 */
	private Integer userId2;
	
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

	/**
	 * @return userId2
	 */
	public Integer getUserId2() {
		return userId2;
	}

	/**
	 * @param userId2 セットする userId2
	 */
	public void setUserId2(Integer userId2) {
		this.userId2 = userId2;
	}

	
	
}
