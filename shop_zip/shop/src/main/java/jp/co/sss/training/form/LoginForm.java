package jp.co.sss.training.form;

public class LoginForm {
private String userId;
private String password;
private String input;

public LoginForm() {
}
public LoginForm(String userId,String password) {
	setUserId(userId);
	setPassword(password);
}

public String getInput() {
	return input;
}
public void setInput(String input) {
	this.input = input;
}

public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

}
