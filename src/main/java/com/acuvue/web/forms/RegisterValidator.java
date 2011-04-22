package com.acuvue.web.forms;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class RegisterValidator  implements Validator{

	public boolean supports(Class<?> arg0) {
		return RegisterForm.class.isAssignableFrom(arg0);
	}
	public void validate(Object arg0, Errors errors) {
		RegisterForm lForm = (RegisterForm)arg0;
		System.out.println("Validator invoked...");
		ValidationUtils.rejectIfEmpty(errors, "emailAddress", "missing.email");
		ValidationUtils.rejectIfEmpty(errors, "password", "missing.password");
		
	}
}
