package com.acuvue.web.forms;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class LoginValidator  implements Validator{

	public boolean supports(Class<?> arg0) {
		return LoginForm.class.isAssignableFrom(arg0);
	}
	public void validate(Object arg0, Errors errors) {
		LoginForm lForm = (LoginForm)arg0;
		System.out.println("Validator invoked...");
		ValidationUtils.rejectIfEmpty(errors, "emailAddress", "missing.email");
		ValidationUtils.rejectIfEmpty(errors, "emailAddress2", "missing.email");
		ValidationUtils.rejectIfEmpty(errors, "password", "missing.password");
		
		/*if( lForm.getPassword()!= null && lForm.getPassword().length() < 6){
			errors.rejectValue("password", "invalid.password");
		}*/
	}
}
