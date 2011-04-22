package com.acuvue.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.acuvue.dao.UserDAO;
import com.acuvue.dao.UserDAO2;
import com.acuvue.exception.InvalidNameException;
import com.acuvue.pdo.User;


public class UserService {

	private UserDAO dao;
	private UserDAO2 dao2;

	public UserDAO getDao() {
		return dao;
	}

	public void setDao(UserDAO dao) {
		this.dao = dao;
	}
	
	public void getUser2() {
		User user = dao2.getUser();
		if (user != null) {
			System.out.println(">>> getUser2: " + user.getFirstName());
			System.out.println(">>> getUser2: " + user.getLastName());
			System.out.println(">>> getUser2: " + user.getDob());
			System.out.println(">>> getUser2: " + user.getGender());
		}
	}
	
	@Transactional(readOnly=true)
	public void updateUser2(){
		
		try{
		dao2.updateUser();
		}catch(Exception e){
		}
		getUser2();
	}

	public void getUser() {
		System.out.println("********getUser() invoked *********");
		User user = dao.getUserById();
		if (user != null) {
			System.out.println("First name:" + user.getFirstName());
		}

		List<User> list = dao.getUserByName("Suresh");

		Iterator itr = list.iterator();
		while (itr.hasNext()) {
			user = (User) itr.next();
			System.out.println("User Id: >>" + user.getUserId());
		}

	}

	public UserDAO2 getDao2() {
		return dao2;
	}

	public void setDao2(UserDAO2 dao2) {
		this.dao2 = dao2;
	}

}
