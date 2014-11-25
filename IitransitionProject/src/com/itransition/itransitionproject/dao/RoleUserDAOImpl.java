package com.itransition.itransitionproject.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.itransition.itransitionproject.dao.interfaces.RoleUserDAO;
import com.itransition.itransitionproject.entity.RoleUser;

public class RoleUserDAOImpl extends BaseDAOImpl implements RoleUserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addRoleUser(RoleUser roleUser) {
		super.addElement(roleUser);
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
