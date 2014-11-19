package com.itransition.itransitionproject.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.itransition.itransitionproject.dao.interfaces.UserDAO;
import com.itransition.itransitionproject.entity.User;
import com.itransition.itransitionproject.util.HibernateUtil;

@Repository
public class UserDAOImpl extends BaseDAOImpl implements UserDAO {
	private static final String SELECT_USER_BY_EMAIL_AND_PASS = "from User where email = :email and password = :password ";
	private static final String SELECT_ALL_FROM_USER = "from User";
	
	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	@Override
    public void addUser(User user) {
        super.addElement(user);
    }
    
	@Override
	public User getUserById(Integer id) {
		return (User)super.getRecordById(User.class, id);
	}

	@Override
	public User getUserByEmailAndPassword(String email, String password) {
		Query query = sessionFactory.openSession().createQuery(SELECT_USER_BY_EMAIL_AND_PASS);
		query.setParameter("email", email);
		query.setParameter("password", password);
		return (User) query.list().get(0);
	}

	@Override
	public List<User> listUser() {
		return sessionFactory.openSession().createQuery(SELECT_ALL_FROM_USER).list();
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
		Query query = sessionFactory.openSession().createQuery(SELECT_USER_BY_EMAIL_AND_PASS);
		query.setParameter("email", email);
		return (User) query.list().get(0);
	}
}
