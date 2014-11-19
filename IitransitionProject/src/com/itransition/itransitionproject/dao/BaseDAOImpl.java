package com.itransition.itransitionproject.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.itransition.itransitionproject.dao.interfaces.BaseDAO;
import com.itransition.itransitionproject.util.HibernateUtil;

public class BaseDAOImpl implements BaseDAO {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@Override
	public Object getRecordById(Class classObject, Integer id) {
		return sessionFactory.openSession().get(classObject, id);
	}

	@Override
	public void addElement(Object object) {
		sessionFactory.openSession().save(object);
	}

	@Override
	public void removeElement(Object object) {
		sessionFactory.openSession().delete(object);
	}

	@Override
	public List<Object> getAllRecords(String queryStr) {
		return sessionFactory.openSession().createQuery(queryStr).list();
	}

	@Override
	public void removeElementById(Integer id, Class classObject) {
		Object object = getRecordById(classObject, id);
		if (object != null)
			removeElement(object);
	}

}
