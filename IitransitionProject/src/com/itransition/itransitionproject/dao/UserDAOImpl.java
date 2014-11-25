package com.itransition.itransitionproject.dao;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.itransition.itransitionproject.dao.interfaces.UserDAO;
import com.itransition.itransitionproject.dao.BaseDAOImpl;
import com.itransition.itransitionproject.entity.User;

@Repository
public class UserDAOImpl extends BaseDAOImpl implements UserDAO {
	private static final String SELECT_USER_BY_EMAIL_AND_PASS = "from User where email = :email and password = :password ";
	private static final String SELECT_USER_BY_EMAIL = "from User where email = :email";
	private static final String SELECT_ALL_FROM_USER = "from User";
	private static final String REMOVE_BY_EMAIL = "delete User where email = ";

	@Override
	public void addUser(User user) {
		if (getUserByEmail(user.getEmail()) == null) {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			user.setPassword(encoder.encode(user.getPassword()));
			super.addElement(user);
		}
	}

	@Override
	public User getUserById(Integer id) {
		return (User) super.getRecordById(User.class, id);
	}

	@Override
	public List<User> listUser() {
		return super.<User>getAllRecords(SELECT_ALL_FROM_USER);
	}

	@Override
	public User getUserByEmail(String email) {
		return (User) super.getByQuery(SELECT_USER_BY_EMAIL, "email", email);
	}

	@Override
	public void removeUser(String email) {
		super.executeQuery(REMOVE_BY_EMAIL + email);
	}

	@Override
	public void updateUser(User user) {
		super.updateObject(user);
	}
}
