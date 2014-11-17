package com.itransition.itransitionproject.dao.interfaces;

import java.util.List;

import org.hibernate.Session;

import com.itransition.itransitionproject.entity.User;

public interface UserDAO {
		
		public void addUser(User user);
		
		public User getUserById(Integer id);
		
		public User getUserByEmailAndPassword(String email, String password);
		
		public User getUserByEmail(String email);
		
		public List<User> listUser();
		
		public void removeUserById(Integer id);
		
		public void removeUser(User user);

}
