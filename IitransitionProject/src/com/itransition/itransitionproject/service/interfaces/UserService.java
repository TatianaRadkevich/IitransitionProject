package com.itransition.itransitionproject.service.interfaces;

import java.util.List;

import com.itransition.itransitionproject.entity.User;

public interface UserService {

	public User getUser(String email);
    
    public User getUserByEmailAndPass(String email, String password);
    
    public void addUser(User user);
    
    public void remoteUser(Integer id);
    
    public void remoteUserByEmail(String email);
    
    public void updateUser(User user);
    
    public List<User> getAllUser();
}
