package com.acuvue.web.forms;

import java.util.ArrayList;

public class LoginForm {

	private String emailAddress;
	private String password;
	
	private String emailAddress2;
	
	public String getEmailAddress2() {
		return emailAddress2;
	}
	public void setEmailAddress2(String emailAddress2) {
		this.emailAddress2 = emailAddress2;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LoginForm() {
		new ArrayList();
	}
	
}
