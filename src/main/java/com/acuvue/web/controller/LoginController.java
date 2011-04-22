package com.acuvue.web.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import com.acuvue.web.forms.LoginForm;

@Controller
@SuppressWarnings("deprecation")
@RequestMapping("/login.htm")
public class LoginController extends SimpleFormController {

	public LoginController() {
		setCommandName("loginform");
		setCommandClass(LoginForm.class);
		setFormView("login");
		setSuccessView("register");
	}

	protected ModelAndView onSubmit(Object command) throws Exception {
		LoginForm loginForm = (LoginForm) command;
		
		System.out.println("Email address:	"+  loginForm.getEmailAddress());
		System.out.println("Password:	"+  loginForm.getPassword());
		
		ModelAndView mav = new ModelAndView(getSuccessView());
		return mav;
	}

}
