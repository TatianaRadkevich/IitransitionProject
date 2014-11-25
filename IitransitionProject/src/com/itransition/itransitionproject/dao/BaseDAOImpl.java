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
		session = getSessionFactory().openSession();
		Object obj = session.get(classObject, id);
		session.flush();
		session.close();
		return obj;
	}

	@Override
	@Transactional
	public void addElement(Object object) {
		session = getSessionFactory().openSession();
		session.save(object);
		session.flush();
		session.close();
	}

	@Override
	@Transactional
	public <T> List<T> getAllRecords(String queryStr) {
		session = getSessionFactory().openSession();
		List<T> list = session.createQuery(queryStr).list();
		session.flush();
		session.close();
		return list;
	}
	
	@Override
	@Transactional
	public void updateObject(Object object) {
		session = getSessionFactory().openSession();
		session.update(object);
		session.flush();
		session.close();
	}
	
	@Override
	@Transactional
	public void removeObject(Class classObject, Integer id) {
		Object obj = getRecordById(classObject, id);
        if (null != obj) {
        	session = getSessionFactory().openSession();
            session.delete(obj);
            session.flush();
    		session.close();
        }
	}
	
	@Override
	@Transactional
	public void executeQuery(String query) {
		Session session = getSessionFactory().openSession();
		session.createQuery(query).executeUpdate();
		session.flush();
		session.close();
	}
	
	@Override
	@Transactional
	public Object getByQuery(String string, String nameParameter, Object parameter) {
		Session session = getSessionFactory().openSession();
		Query query = session.createQuery(string);
		query.setParameter(nameParameter, parameter);
		List<Object> list = query.list();
		session.flush();
		session.close();
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
}
