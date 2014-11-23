package com.itransition.itransitionproject.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

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
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		baseDAO.addElement(user);
	}

	@Override
	public User getUserById(Integer id) {
		return (User) super.getRecordById(User.class, id);
	}

	@Override
	public User getUserByEmailAndPassword(String email, String password) {
		Query query = getSessionFactory().getCurrentSession().createQuery(
				SELECT_USER_BY_EMAIL_AND_PASS);
		query.setParameter("email", email);
		query.setParameter("password", password);
		return (User) query.list().get(0);
	}

	@Override
	public List<User> listUser() {
		return getSessionFactory().getCurrentSession()
				.createQuery(SELECT_ALL_FROM_USER).list();
	}

	@Override
	public void removeUserById(Integer id) {
		super.removeElementById(id, User.class);
	}

	@Override
	public void removeUser(User user) {
		super.removeElement(user);
	}

	@Override
	public User getUserByEmail(String email) {
		System.err.println("get User y email!!! email = " + email);
		Query query = getSessionFactory().openSession().createQuery(
				SELECT_USER_BY_EMAIL);
		query.setParameter("email", email);
		User user = (User) query.list().get(0);
		System.err.println("get user = " + user);
		return (User) query.list().get(0);
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
}
