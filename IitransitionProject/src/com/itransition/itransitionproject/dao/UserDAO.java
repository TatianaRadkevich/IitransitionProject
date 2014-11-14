package com.itransition.itransitionproject.dao;

import java.util.List;

import com.itransition.itransitionproject.domain.User;

public interface UserDAO {
	
	public void addUser(User user);
	
	public User getUser(Integer id);
	
	public List<User> listUser();
	
	public void removeUser(Integer id);

}
