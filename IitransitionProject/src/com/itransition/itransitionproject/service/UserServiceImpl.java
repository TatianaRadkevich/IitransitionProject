package com.itransition.itransitionproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itransition.itransitionproject.dao.UserDAO;
import com.itransition.itransitionproject.domain.User;

@Service
public class UserServiceImpl implements UserService {
 
    @Autowired
    private UserDAO userDAO;
 
    @Transactional
    public void addUser(User user) {
    	userDAO.addUser(user);
    }
 
    @Transactional
    public List<User> listUser() { 
        return userDAO.listUser();
    }
 
    @Transactional
    public void removeUser(Integer id) {
    	userDAO.removeUser(id);
    }
}