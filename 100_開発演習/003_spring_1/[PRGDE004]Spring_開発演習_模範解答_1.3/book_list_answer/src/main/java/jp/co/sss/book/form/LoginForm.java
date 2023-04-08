package jp.co.sss.book.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class LoginForm {
	@Max(value = 99999)
	private String bookUserId;

	@NotBlank
	@Size(max = 16)
	@Pattern(regexp = "^[a-zA-Z0-9]+$")
	private String password;

	public String getBookUserId() {
		return bookUserId;
	}

	public void setBookUserId(String bookUserId) {
		this.bookUserId = bookUserId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
