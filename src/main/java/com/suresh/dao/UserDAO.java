package com.suresh.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.suresh.pdo.User;

public class UserDAO {

    private SessionFactory sessionFactory;
    private HibernateTemplate template;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        template = new HibernateTemplate(sessionFactory);
    }

    public User getUserById() {
    	 return template.load(User.class, new Integer(11938));
    }
    
    public List getUserByName(String name) {
   	 return template.find("from User user where user.firstName ='"+name+"'");
   }
    
    
    public User getUserById(String userId) {
    	template.executeWithNewSession(new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                Query query = session.createQuery("from User user where user.userId=11938");
                query.setMaxResults(2);
                List users = query.list();
                User user= null;
                if(users.get(0)!= null){
                    user= (User) users.get(0);
                    System.out.println("user:  "+ user.getFirstName());
                    return user;
                }
                return null;
            }
        });
        
        return null;
//        return (User)this.sessionFactory.getCurrentSession()
//                .createQuery("from com.acuvue.pdo.User user where user.userId=11938").list().get(0);
    }
}
