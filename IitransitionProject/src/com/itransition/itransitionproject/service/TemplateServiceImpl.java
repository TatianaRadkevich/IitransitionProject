package com.itransition.itransitionproject.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.itransition.itransitionproject.dao.interfaces.TemplateDAO;
import com.itransition.itransitionproject.entity.TemplateTable;
import com.itransition.itransitionproject.entity.User;
import com.itransition.itransitionproject.service.interfaces.TemplateService;

public class TemplateServiceImpl implements TemplateService {

	@Autowired
	private TemplateDAO templateDAO; 
	
	@Override
	public void addRef(User user, String ref) {
		TemplateTable table = new TemplateTable();
		table.setRef(ref);
		table.setUser(user);
		templateDAO.addRef(table);
	}


	@Override
	public void remoteRef(TemplateTable table) {
		templateDAO.remoteRef(table);
	}
	
	/**
	 * @return the templateDAO
	 */
	public TemplateDAO getTemplateDAO() {
		return templateDAO;
	}

	/**
	 * @param templateDAO the templateDAO to set
	 */
	public void setTemplateDAO(TemplateDAO templateDAO) {
		this.templateDAO = templateDAO;
	}


	@Override
	public TemplateTable findRef(String ref) {
		return templateDAO.getTemplateTable(ref);
	}

}
