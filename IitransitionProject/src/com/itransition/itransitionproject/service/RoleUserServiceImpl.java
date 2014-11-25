package com.itransition.itransitionproject.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.itransition.itransitionproject.dao.interfaces.RoleUserDAO;
import com.itransition.itransitionproject.entity.RoleUser;
import com.itransition.itransitionproject.service.interfaces.RoleUserService;

public class RoleUserServiceImpl implements RoleUserService {

	@Autowired
	private RoleUserDAO roleUserDAO;
	
	@Override
	public void addRole(RoleUser roleUser) {
		roleUserDAO.addRoleUser(roleUser);
	}

	/**
	 * @return the roleUserDAO
	 */
	public RoleUserDAO getRoleUserDAO() {
		return roleUserDAO;
	}

	/**
	 * @param roleUserDAO the roleUserDAO to set
	 */
	public void setRoleUserDAO(RoleUserDAO roleUserDAO) {
		this.roleUserDAO = roleUserDAO;
	}

}
