package com.itransition.itransitionproject.service;

import java.util.List;

import com.itransition.itransitionproject.domain.User;

public interface UserService {
	
	public void addUser(User user);
	
	public List<User> listUser();
	
	public void removeUser(Integer id);

}
