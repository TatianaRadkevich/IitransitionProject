package com.itransition.itransitionproject.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.itransition.itransitionproject.dao.interfaces.BaseDAO;

public class BaseDAOImpl implements BaseDAO {

	private Session session;
	@Autowired
	private SessionFactory sessionFactory ;
	
	@Override
	public Object getRecordById(Class classObject, Integer id) {
		Object obj = getSession().get(classObject, id);
		return obj;
	}

	@Override
	public void addElement(Object object) {
		getSession().save(object);
	}

	@Override
	public <T> List<T> getAllRecords(String queryStr) {
		List<T> list = getSession().createQuery(queryStr).list();
		return list;
	}
	
	@Override
	public void updateObject(Object object) {
		getSession().update(object);
	}
	
	@Override
	public void removeObject(Class classObject, Integer id) {
		Object obj = getRecordById(classObject, id);
        if (null != obj) {
        	getSession().delete(obj);
        }
	}
	
	@Override
	public void executeQuery(String query) {
		getSession().createQuery(query).executeUpdate();
	}
	
	@Override
	public Object getByQuery(String string, String nameParameter, Object parameter) {
		Query query = getSession().createQuery(string);
		query.setParameter(nameParameter, parameter);
		List<Object> list = query.list();
		if (null == list || list.isEmpty())
			return null;
		return list.get(0);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private Session getSession() {
		if ( session == null || !session.isOpen() || !session.isConnected())//{
			session = getSessionFactory().openSession();
		return session;
	}
}
