package jp.co.sss.shop.form;


/**
 * お問い合わせフォームクラス
 *
 * @author TEAM_AKIBA
 *
 */
public class ContactForm {

	String name;

	String email;

	String subject;

	String message;
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email セットする email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return subject
	 */
	public String getSubject() {
		return subject;
	}
	/**
	 * @param subject セットする subject
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	/**
	 * @return message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message セットする message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}
