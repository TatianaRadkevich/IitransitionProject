package com.itransition.itransitionproject.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.itransition.itransitionproject.dao.interfaces.BaseDAO;

@Transactional
public class BaseDAOImpl implements BaseDAO {

	private Session session;
	
	@Autowired
	private SessionFactory sessionFactory ;
	
	@Override
	@Transactional
	public Object getRecordById(Class classObject, Integer id) {
		checkSession();
		Object obj = session.get(classObject, id);
		return obj;
	}

	@Override
	@Transactional
	public void addElement(Object object) {
		checkSession();
		session.save(object);
	}

	@Override
	@Transactional
	public <T> List<T> getAllRecords(String queryStr) {
		checkSession();
		List<T> list = session.createQuery(queryStr).list();
		return list;
	}
	
	@Override
	@Transactional
	public void updateObject(Object object) {
		checkSession();
		session.update(object);
	}
	
	@Override
	@Transactional
	public void removeObject(Class classObject, Integer id) {
		Object obj = getRecordById(classObject, id);
        if (null != obj) {
        	checkSession();
            session.delete(obj);
        }
	}
	
	@Override
	@Transactional
	public void executeQuery(String query) {
		checkSession();
		session.createQuery(query).executeUpdate();
	}
	
	@Override
	@Transactional
	public Object getByQuery(String string, String nameParameter, Object parameter) {
		checkSession();
		Query query = session.createQuery(string);
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
	
	private void checkSession() {
		if (null == session || !session.isOpen() || !session.isConnected())
			session = sessionFactory.openSession();
	}
}
