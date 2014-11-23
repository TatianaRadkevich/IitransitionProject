package com.itransition.itransitionproject.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.itransition.itransitionproject.dao.interfaces.BaseDAO;

public class BaseDAOImpl implements BaseDAO {

	@Autowired
	private SessionFactory sessionFactory ;
//	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@Override
	public Object getRecordById(Class classObject, Integer id) {
		return getSessionFactory().getCurrentSession().get(classObject, id);
	}

	@Override
	public void addElement(Object object) {
		System.err.println("session = "+sessionFactory+" ob = "+object);
//		getSessionFactory().getCurrentSession().save(object);
		getSessionFactory().openSession().save(object);
	}

	@Override
	public void removeElement(Object object) {
		getSessionFactory().getCurrentSession().delete(object);
	}

	@Override
	public List<Object> getAllRecords(String queryStr) {
		return getSessionFactory().getCurrentSession().createQuery(queryStr).list();
	}

	@Override
	public void removeElementById(Integer id, Class classObject) {
		Object object = getRecordById(classObject, id);
		if (object != null)
			removeElement(object);
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
	
	

}
