package com.itransition.itransitionproject.dao.interfaces;

import java.util.List;

import org.hibernate.Session;

import com.itransition.itransitionproject.entity.User;

public interface UserDAO {
		
		public void addUser(User user);
		
		public User getUserById(Integer id);
		
		public User getUserByEmail(String email);
		
		public List<User> listUser();
		
		public void removeUser(String email);
		
		public void updateUser(User user);
}
