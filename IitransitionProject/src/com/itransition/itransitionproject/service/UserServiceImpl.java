package com.itransition.itransitionproject.service;

import java.util.List;

import com.itransition.itransitionproject.dao.UserDAOImpl;
import com.itransition.itransitionproject.dao.interfaces.UserDAO;
import com.itransition.itransitionproject.entity.User;
import com.itransition.itransitionproject.service.interfaces.UserService;
import com.itransition.itransitionproject.util.HibernateUtil;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;
	
    @Override
    @Transactional
    public User getUser(String email) {
        return userDAO.getUserByEmail(email);
    }

	@Override
	@Transactional
	public User getUserByEmailAndPass(String email, String password) {
		return userDAO.getUserByEmailAndPassword(email, password);
	}

	@Override
	@Transactional
	public void addUser(User user) {
		userDAO.addUser(user);
	}

	@Override
	@Transactional
	public void remoteUser(Integer id) {
		userDAO.removeUserById(id);
	}

	@Override
	@Transactional
	public void remoteUserByEmail(String email) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void updateUser(User user) {
	//	userDAO
	}

	@Override
	@Transactional
	public List<User> getAllUser() {
		return userDAO.listUser();
	}

}
