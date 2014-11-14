package com.itransition.itransitionproject.service;

import java.util.List;

import com.itransition.itransitionproject.domain.User;

public interface UserService {
	
	public void addUser(User user);
	
	public User getUser(Integer id);
	
	public List<User> listUser();
	
	public void removeUser(Integer id);

}
