package com.acuvue.web.controller;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.acuvue.exception.InvalidNameException;
import com.acuvue.service.UserService;
import com.acuvue.web.domain.State;
import com.acuvue.web.domain.User;

@Controller
@RequestMapping("/register/**")
@SessionAttributes("user")
public class RegisterController {
	
	private UserService userService; 
	
	//This method will be invoked before @RequestMapping annotated handler method.
	@ModelAttribute("stateList")
	public List<State> initForm() {
		System.out.println("@ModelAttribute annotated metod invoked..");
		ArrayList<State> stateList = new ArrayList<State>();
		stateList.add(new State(1, "Florida"));
		stateList.add(new State(2, "Texas"));
		stateList.add(new State(3, "Wisconsin"));
		stateList.add(new State(3, "Washington"));
		return stateList;
	}

	@RequestMapping( value="**/user", method = RequestMethod.GET)
	public String displayForm(ModelMap model, @RequestParam(value="locale", required=false) String locale, @RequestHeader("Host") String host){
		System.out.println("Request locale:	" + locale);
		System.out.println("Request Host:	" + host);
		User user = new User();
		user.setEmailAddress("sam@jnj.com");
		model.addAttribute("user",  user);
		model.addAttribute("locale", locale);
		//userService.getUser();
		//userService.getUser2();
		userService.updateUser2();
		return "createProfile";
	}

	//@ModelAttribute("user") User user - maps the "user" form bean data from View to domain object.
	@RequestMapping(method = RequestMethod.POST)
	public String saveForm(@ModelAttribute("user") User user) {
		System.out.println(" Email address: " +   user.getEmailAddress());
		return "redirect:jsp/confirm.jsp"; // redirect used here to prevent form double submission.
	}

	/*@RequestMapping(method = RequestMethod.GET)
	public String testException() throws Exception{
		throw new Exception();
	}*/
	
	
	@ExceptionHandler(Exception.class)
	  public String handleIOException(Exception ex, HttpServletRequest request) {
	    return "404";
	  }

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}
