package com.suresh.dao;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.suresh.exception.InvalidNameException;
import com.suresh.pdo.User;

public class UserDAO2 {
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void updateUser() throws InvalidNameException{
		System.out.println("\n******** updateUser *********");
		Session session = getSessionFactory().getCurrentSession();
		User user = (User)session.load(User.class, new Integer(11938));
		if(user.getFirstName().length() <= 1){
			throw new InvalidNameException();
		}else{
			user.setFirstName("Suresh-"+ new Date());
		}
		session.saveOrUpdate(user);
		//throw new InvalidDataException();
	}
	
	public User getUser(){
		System.out.println("\n******** getUser *********");
		return (User)getSessionFactory().getCurrentSession().load(User.class, new Integer(11938));
	}

}
