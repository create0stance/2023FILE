package jp.co.sss.shop.form;

import java.io.Serializable;

/**
 * フォームデータを保持するクラス
 *
 */
public class LoginForm implements Serializable {

	/*
	 * Formクラス：
	 * Formデータを保管するためのクラス。
	 * ・フィールド名を、パラメータ名と同名にする。
	 * ・命名規則に従ったsetter,getterを持っている
	 */
	/** userId */
	private Integer userId;
	
	
	/** パスワード */
	private String password;
	
	/**
	 * ユーザーIDを取得
	 * @return userId
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * パスワードを取得
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

	@Override
	public String toString() {
		return "userId:" + userId;
	}

	
}
