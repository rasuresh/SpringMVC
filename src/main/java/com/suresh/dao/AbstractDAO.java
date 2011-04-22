package com.suresh.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractDAO {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void save(Object dbo) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(dbo);
			session.flush();
		} catch (HibernateException e) {
			throw e;
		}
	}

	@Transactional
	public void saveOrUpdate(Object dbo) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.saveOrUpdate(dbo);
			session.flush();
		} catch (HibernateException e) {
			throw e;
		}
	}

	@Transactional
	public void update(Object dbo) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(dbo);
			session.flush();
		} catch (HibernateException e) {
			throw e;
		}
	}

	@Transactional
	public void delete(Object dbo) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.delete(dbo);
			session.flush();
		} catch (HibernateException e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	protected List execQuery(String queryStr) {
		Session session = sessionFactory.getCurrentSession();
		try {
			return session.createQuery(queryStr).list();
		} catch (HibernateException e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	protected List execSqlQuery(String queryStr) {
		Session session = sessionFactory.getCurrentSession();
		try {
			return session.createSQLQuery(queryStr).list();
		} catch (HibernateException e) {
			throw e;
		}
	}

	protected int deleteRows(String queryStr) {
		Session session = sessionFactory.getCurrentSession();
		try {
			Transaction tx = session.beginTransaction();
			Query query = session.createSQLQuery(queryStr);
			int row = query.executeUpdate();
			return row;
		} catch (HibernateException e) {
			throw e;
		}
	}

	protected Object getObject(Class clazz, Serializable id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			return session.get(clazz, id);
		} catch (HibernateException e) {
			throw e;
		} 
	}
}
