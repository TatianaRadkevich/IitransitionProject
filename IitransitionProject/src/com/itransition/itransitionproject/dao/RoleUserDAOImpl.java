package com.itransition.itransitionproject.dao;


import org.springframework.stereotype.Repository;

import com.itransition.itransitionproject.dao.interfaces.RoleUserDAO;
import com.itransition.itransitionproject.entity.RoleUser;

@Repository
public class RoleUserDAOImpl extends BaseDAOImpl implements RoleUserDAO {
	
	@Override
	public void addRoleUser(RoleUser roleUser) {
		super.addElement(roleUser);
	}
}
