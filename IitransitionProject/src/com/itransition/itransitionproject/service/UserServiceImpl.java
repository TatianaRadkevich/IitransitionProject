package com.itransition.itransitionproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.itransition.itransitionproject.dao.interfaces.UserDAO;
import com.itransition.itransitionproject.entity.User;
import com.itransition.itransitionproject.service.interfaces.UserService;

@Service
public class UserServiceImpl implements UserService{

	private UserDAO userDAO;

	@Override
	public User getUser(String email) {
		return userDAO.getUserByEmail(email);
	}

	@Override
	public void addUser(User user) {
		userDAO.addUser(user);
	}


	@Override
	public void remoteUserByEmail(String email) {
		userDAO.removeUser(email);
	}

	@Override
	public void updateUser(User user) {
		userDAO.updateUser(user);
	}

	@Override
	public List<User> getAllUser() {
		return userDAO.listUser();
	}

	/**
	 * @return the userDAO
	 */
	public UserDAO getUserDAO() {
		return userDAO;
	}

	/**
	 * @param userDAO the userDAO to set
	 */
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

}
