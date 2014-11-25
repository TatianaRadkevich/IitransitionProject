package com.itransition.itransitionproject.dao;


import com.itransition.itransitionproject.dao.interfaces.RoleUserDAO;
import com.itransition.itransitionproject.entity.RoleUser;

public class RoleUserDAOImpl extends BaseDAOImpl implements RoleUserDAO {
	
	@Override
	public void addRoleUser(RoleUser roleUser) {
		super.addElement(roleUser);
	}
}
