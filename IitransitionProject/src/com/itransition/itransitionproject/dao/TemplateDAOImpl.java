package com.itransition.itransitionproject.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.itransition.itransitionproject.dao.interfaces.TemplateDAO;
import com.itransition.itransitionproject.entity.TemplateTable;

public class TemplateDAOImpl extends BaseDAOImpl implements TemplateDAO {

	private static final String SELECT_REF = "from TemplateTable where ref = :ref";
	private static final String DELETE_TABLE = "delete TemplateTable where id_table = ";
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addRef(TemplateTable table) {
		super.addElement(table);
	}

	@Override
	@Transactional
	public void remoteRef(TemplateTable table) {
		super.executeQuery(DELETE_TABLE + table.getId_table());
	}

	@Override
	@Transactional
	public TemplateTable getTemplateTable(String ref) {
		return (TemplateTable) super.getByQuery(SELECT_REF, "ref", ref);
	}

}
