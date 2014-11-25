package com.itransition.itransitionproject.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.itransition.itransitionproject.dao.interfaces.BaseDAO;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@Transactional
public class BaseDAOImpl implements BaseDAO {

	private Session session;
	
	@Autowired
	private SessionFactory sessionFactory ;
	
	@Override
	public Object getRecordById(Class classObject, Integer id) {
		return getSessionFactory().getCurrentSession().get(classObject, id);
	}

	@Override
	public void addElement(Object object) {
	//	getSessionFactory().getCurrentSession().save(object);
		session = getSessionFactory().openSession();
		session.save(object);
		session.flush();
		session.close();
	}

	@Override
	public List<Object> getAllRecords(String queryStr) {
		session = getSessionFactory().openSession();
		List<Object> list = session.createQuery(queryStr).list();
		session.flush();
		session.close();
		return list;
	}

	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void updateObject(Object object) {
		session = getSessionFactory().openSession();
		session.update(object);
		session.flush();
		session.close();
	}
}
