package com.itransition.itransitionproject.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.itransition.itransitionproject.dao.interfaces.UserDAO;
import com.itransition.itransitionproject.dao.BaseDAOImpl;
import com.itransition.itransitionproject.dao.interfaces.BaseDAO;
import com.itransition.itransitionproject.entity.User;

@Repository
public class UserDAOImpl extends BaseDAOImpl implements UserDAO {
	private static final String SELECT_USER_BY_EMAIL_AND_PASS = "from User where email = :email and password = :password ";
	private static final String SELECT_USER_BY_EMAIL = "from User where email = :email";
	private static final String SELECT_ALL_FROM_USER = "from User";

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private BaseDAO baseDAO;

	@Override
	public void addUser(User user) {
		if (getUserByEmail(user.getEmail()) == null) {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			user.setPassword(encoder.encode(user.getPassword()));
			baseDAO.addElement(user);
		}
	}

	@Override
	public User getUserById(Integer id) {
		return (User) super.getRecordById(User.class, id);
	}

	@Override
	@Transactional
	public List<User> listUser() {
		Session session = getSessionFactory().openSession();
		List<User> list = session.createQuery(SELECT_ALL_FROM_USER).list();
		session.flush();
		session.close();
		return list;
	}

	@Override
	@Transactional
	public User getUserByEmail(String email) {
	Session session = getSessionFactory().openSession();
		Query query = session.createQuery(SELECT_USER_BY_EMAIL);
	//	Query query = sessionFactory.getCurrentSession().createQuery(SELECT_USER_BY_EMAIL);
		query.setParameter("email", email);
		User user = null;
		try{
			user = (User)query.list().get(0);
		}catch(IndexOutOfBoundsException e){
			
		}
		session.flush();
		session.close();
		return user;
	}

	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory
	 *            the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * @return the baseDAO
	 */
	public BaseDAO getBaseDAO() {
		return baseDAO;
	}

	/**
	 * @param baseDAO
	 *            the baseDAO to set
	 */
	public void setBaseDAO(BaseDAO baseDAO) {
		this.baseDAO = baseDAO;
	}

	@Override
	@Transactional
	public void removeUser(String email) {
		Session session = getSessionFactory().openSession();
		session.createQuery("delete User where email = " + email) 
				.executeUpdate();
		session.flush();
		session.close();
	}

	@Override
	public void updateUser(User user) {
		super.updateObject(user);
	}
}
