package com.itransition.itransitionproject.dao;

import org.springframework.stereotype.Repository;

import com.itransition.itransitionproject.dao.interfaces.TemplateDAO;
import com.itransition.itransitionproject.entity.TemplateTable;

@Repository
public class TemplateDAOImpl extends BaseDAOImpl implements TemplateDAO {

	private static final String SELECT_REF = "from TemplateTable where ref = :ref";
	
	@Override
	public void addRef(TemplateTable table) {
		super.addElement(table);
	}

	@Override
	public void remoteRef(TemplateTable table) {
		super.deleteObject(table);
	}

	@Override
	public TemplateTable getTemplateTable(String ref) {
		return (TemplateTable) super.getByQuery(SELECT_REF, "ref", ref);
	}

}
