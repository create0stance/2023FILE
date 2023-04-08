package jp.co.sss.book.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book_user")
public class BookUser {

	/**
	 * ユーザID
	 */
	@Id
	private Integer bookUserId;


	/**
	 * ユーザ名
	 */
	@Column
	private String bookUserName;

	/**
	 * パスワード
	 */
	@Column
	private String password;

	/**
	 * ユーザIDを取得
	 * @return ユーザID
	 */
	public Integer getBookUserId() {
		return bookUserId;
	}

	/**
	 * ユーザIDを保存
	 * @param bookUserId ユーザID
	 */
	public void setBookUserId(Integer bookUserId) {
		this.bookUserId = bookUserId;
	}

	/**
	 * ユーザ名を取得
	 * @return ユーザ名
	 */
	public String getBookUserName() {
		return bookUserName;
	}

	/**
	 * ユーザ名を保存
	 * @param bookUserName ユーザ名
	 */
	public void setBookUserName(String bookUserName) {
		this.bookUserName = bookUserName;
	}

	/**
	 * パスワードを取得
	 * @return パスワード
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * パスワードを保存
	 * @param password パスワード
	 */
	public void setPassword(String password) {
		this.password = password;
	}


}